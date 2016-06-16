/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verificar;

import Conexao.Conexao;
import Util.DateUtil;
import java.sql.SQLException;
import java.text.ParseException;

/** VerificarVenda
 * Possui método para verificação dos dados da venda
 * @author Guillermo1
 */
public class VerificarVenda {
    
    /** verificar
     * Verifica se o valor está válido
     * @param coluna tipo de validação
     * @param valor valor a validar
     * @return Retorna true se estiver correto, retorna false se estiver errado
     */
    public static boolean verificar(String coluna,String valor){
        try{
            switch (coluna) {
                case "data":
                    if(valor.isEmpty())
                        throw new Exception("Data está vazia!");
                    DateUtil.stringToDateHour(valor);
                    break;
                case "qtd":
                    if(valor.isEmpty())
                        throw new Exception("Quantidade está vazia!");
                    else if(!valor.matches("[0-9]+"))
                        throw new Exception("Quantidade deve ser um número!");
                    break;
                case "conta":
                    if(valor.isEmpty())
                        throw new Exception("Conta está vazia!");
                    break;
                default:
                    throw new Exception("Coluna inválida!");
            }
        }catch(Exception ex){
            if(ex instanceof ParseException)
                System.out.println("Data inválida!");
            else
                System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    /** vendaExiste
     * Verifica se a Venda existe
     * @param valor valor a procurar
     * @param coluna coluna a procurar
     * @param falar_existe mostrar mensagem se existe
     * @param falar_nao_existe mostrar mensagem se não existe
     * @return True se existe e False se não existe
     */
    public static boolean vendaExiste(String coluna,String valor,boolean falar_existe,boolean falar_nao_existe){
        try {
            if(Conexao.selecionar("SELECT * FROM VENDA WHERE "+coluna+" = '"+valor+"';").isBeforeFirst()){
                if(falar_existe == true)
                    System.out.println("Venda já existe!");
                return true;
            }
            if(falar_nao_existe == true)
                System.out.println("Venda não existe");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
}
