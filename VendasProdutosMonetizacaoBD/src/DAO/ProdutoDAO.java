package DAO;

import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

/** ProdutoDAO
 * Executa comandos sql relacionados a tabela Produto.
 * @author Guillermo1
 */
public class ProdutoDAO {
    private static ResultSet selecao;
    
    /** cadastrar
     * Cadastra o produto
     * @param nome
     * @param preco
     */
    public static void cadastrar(String nome,String preco){
        Conexao.executar("INSERT INTO PRODUTO(NOME,PRECO) VALUES('"+nome+"',"+preco+");");
    }
    /** deletar
     * Deleta o produto
     * @param coluna referencia para deletar
     * @param valor valor de referencia para deletar
     */
    public static void deletar(String coluna,String valor){
        Conexao.executar("DELETE FROM PRODUTO WHERE "+coluna+" = '"+valor+"';");
    }
    
    /** atualizar
     * atualiza o produto
     * @param coluna1 coluna a atualizar
     * @param valor1 novo valor da coluna
     * @param coluna2 referencia para atualizar
     * @param valor2 valor da referencia para atualizar
     */
    public static void atualizar(String coluna1,String valor1,String coluna2,String valor2){
        Conexao.executar("UPDATE PRODUTO SET "+coluna1+" = '"+valor1+"' WHERE "+coluna2+" = '"+valor2+"';");
    }    
    
    /** selecionar
     * seleciona o produto
     * @param coluna coluna a selecionar
     * @param valor valor a selecionar
     */
    public static void selecionar(String coluna,String valor){
        selecao = Conexao.selecionar("SELECT * FROM PRODUTO WHERE "+coluna+" = '"+valor+"';");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Produto não existe!");
            else{
                while(selecao.next()){
                    System.out.println("ID:"+selecao.getInt(1)+","
                            + "Nome:"+selecao.getString(2)+","
                            + "Preço:"+selecao.getDouble(3)+";");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** selecionarTudo
     * seleciona todos os produtos
     */
    public static void selecionarTudo(){
        selecao = Conexao.selecionar("SELECT * FROM PRODUTO;");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Não há produtos cadastrados!");
            else{
                while(selecao.next()){
                    System.out.println("ID:"+selecao.getInt(1)+","
                            + "Nome:"+selecao.getString(2)+","
                            + "Preço:"+selecao.getDouble(3)+";");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
