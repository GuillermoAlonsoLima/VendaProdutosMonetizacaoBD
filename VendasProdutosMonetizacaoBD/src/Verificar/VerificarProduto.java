package Verificar;

import Conexao.Conexao;
import java.sql.SQLException;
import java.text.ParseException;

/** Verificar Produto
 * Possui método para verificação dos dados do produto
 * @author Guillermo1
 */
public class VerificarProduto {
     /** verificar
     * Verifica se o valor está válido
     * @param coluna tipo de validação
     * @param valor valor a validar
     * @return Retorna true se estiver correto, retorna false se estiver errado
     */
    public static boolean verificar(String coluna,String valor){
        try{
            switch (coluna) {
                case "nome":
                    if(valor.isEmpty())
                        throw new Exception("Nome está vazio!");
                    break;
                case "preco":
                    if(valor.isEmpty())
                        throw new Exception("Preço está vazio!");
                    Double.parseDouble(valor);
                    break;
                default:
                    throw new Exception("Coluna inválida!");
            }
        }catch(Exception ex){
            if(ex instanceof ParseException)
                System.out.println("Preço inválido!");
            else
                System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    
    /** produtoExiste
     * Verifica se o Produto existe
     * @param valor valor a procurar
     * @param coluna coluna a procurar
     * @param falar_existe mostrar mensagem se existe
     * @param falar_nao_existe mostrar mensagem se não existe
     * @return True se existe e False se não existe
     */
    public static boolean produtoExiste(String coluna,String valor,boolean falar_existe,boolean falar_nao_existe){
        try {
            if(Conexao.selecionar("SELECT * FROM PRODUTO WHERE "+coluna+" = '"+valor+"';").isBeforeFirst()){
                if(falar_existe == true)
                    System.out.println("Produto já existe!");
                return true;
            }
            if(falar_nao_existe == true)
                System.out.println("Produto não existe");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
