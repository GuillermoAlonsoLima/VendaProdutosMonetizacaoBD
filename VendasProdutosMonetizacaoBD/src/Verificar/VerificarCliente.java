/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verificar;

import Conexao.Conexao;
import java.sql.SQLException;

/** Verificar Cliente
 * Possui método para verificação dos dados do cliente
 * @author Guillermo1
 */
public class VerificarCliente {

    /** verificar
     * Verifica se o valor está válido
     * @param coluna tipo de validação
     * @param valor valor a validar
     * @return Retorna true se estiver correto, retorna false se estiver errado
     */
    public static boolean verificar(String coluna,String valor){
        try{
            switch (coluna) {
                case "cpf":                    
                    if(valor.isEmpty())
                        throw new Exception("CPF está vazio!");
                    else if(valor.length()!=11)
                        throw new Exception("CPF deve ter 11 números!");
                    else if(!valor.matches("[0-9]+"))
                        throw new Exception("CPF deve ter domente números!");
                    break;
                case "nome":
                    if(valor.isEmpty())
                        throw new Exception("Nome está vazio!");
                    else if(!Character.isUpperCase(valor.charAt(0)))
                        throw new Exception("Nome deve começar em maiúsculo!");
                    else if(valor.split("\\s+").length != 3)
                        throw new Exception("Nome incompleto!");
                    else if(valor.matches(".*\\d+.*"))
                        throw new Exception("Nome não deve ter números!");
                    break;
                case "email":
                    if(valor.isEmpty())
                        throw new Exception("E-mail está vazio!");
                    else if(!valor.matches("^(.+)@(.+)$"))
                        throw new Exception("E-mail inválido!");
                    else if(!valor.matches(valor.toLowerCase()))
                        throw new Exception("Email deve estar em minúsculo!");
                    break;
                default:
                    throw new Exception("Coluna inválida!");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    /** clienteExiste
     * Verifica se o Cliente existe
     * @param cpf CPF a verificar
     * @return True se existe e False se não existe
     */
    public static boolean clienteExiste(String cpf){
        try {
            if(Conexao.selecionar("SELECT * FROM CLIENTE WHERE CPF = '"+cpf+"';").isBeforeFirst()){
                System.out.println("Cliente já existe!");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
