/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verificar;

import Conexao.Conexao;
import java.sql.SQLException;
import java.text.ParseException;

/** VerificarConta
 * Possui método para verificação dos dados da conta
 * @author Guillermo1
 */
public class VerificarConta {
    /** verificar
     * Verifica se o valor está válido
     * @param coluna tipo de validação
     * @param valor valor a validar
     * @return Retorna true se estiver correto, retorna false se estiver errado
     */
    public static boolean verificar(String coluna,String valor){
        try{
            switch (coluna) {
                case "usuario":
                    if(valor.isEmpty())
                        throw new Exception("Usuario está vazio!");
                break;
                case "senha":
                    if(valor.isEmpty())
                        throw new Exception("Senha está vazia!");
                    else if(!valor.matches(".*[a-zA-Z]+.*"))
                        throw new Exception("Senha deve ter letras!");
                    else if(!valor.matches(".*[0-9]+.*"))
                        throw new Exception("Senha deve ter números!");
                    break;
                case "saldo":
                    Double.parseDouble(valor);
                    break;
                case "cliente":
                    if(valor.isEmpty())
                        throw new Exception("CPF está vazio!");
                    else if(valor.length()!=11)
                        throw new Exception("CPF deve ter 11 números!");
                    else if(!valor.matches("[0-9]+"))
                        throw new Exception("CPF deve ter somente números!");
                    break;
                default:
                    throw new Exception("Coluna inválida!");
            }
        }catch(ParseException e){
            System.out.println("Saldo inválido");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    /** contaExiste
     * Verifica se a Conta existe
     * @param valor valor a procurar
     * @param coluna coluna a procurar
     * @param falar_existe mostrar mensagem se existe
     * @param falar_nao_existe mostrar mensagem se não existe
     * @return True se existe e False se não existe
     */
    public static boolean contaExiste(String coluna,String valor,boolean falar_existe,boolean falar_nao_existe){
        try {
            if(Conexao.selecionar("SELECT * FROM CONTA WHERE "+coluna+" = '"+valor+"';").isBeforeFirst()){
                if(falar_existe == true)
                    System.out.println("Conta já existe!");
                return true;
            }
            if(falar_nao_existe == true)
                System.out.println("Conta não existe");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
