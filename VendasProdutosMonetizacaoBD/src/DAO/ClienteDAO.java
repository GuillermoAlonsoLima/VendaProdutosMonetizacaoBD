package DAO;

import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

/** ClienteDAO
 * Executa comandos sql relacionados a tabela Cliente.
 * @author Guillermo1
 */
public class ClienteDAO {
    private static ResultSet selecao;
    
    /** cadastrar
     *  Cadastra o cliente
     * @param cpf
     * @param nome
     * @param email
     */
    public static void cadastrar(String cpf,String nome,String email){
        Conexao.executar("INSERT INTO CLIENTE VALUES("+cpf+",'"+nome+"','"+email+"');");
    }
    
    /** deletar
     * Deleta o cliente
     * @param coluna referencia para deletar
     * @param valor valor de referencia para deletar
     */
    public static void deletar(String coluna,String valor){
        Conexao.executar("DELETE FROM CLIENTE WHERE "+coluna+" = '"+valor+"';");        
    }
    
    /** atualizar
     * atualiza o cliente
     * @param coluna1 coluna a atualizar
     * @param valor1 novo valor da coluna
     * @param coluna2 referencia para atualizar
     * @param valor2 valor da referencia para atualizar
     */
    public static void atualizar(String coluna1,String valor1,String coluna2,String valor2){
        Conexao.executar("UPDATE CLIENTE SET "+coluna1+" = '"+valor1+"' WHERE "+coluna2+" = '"+valor2+"';");
    }    
    
    /** selecionar
     * seleciona o cliente
     * @param coluna coluna a selecionar
     * @param valor valor a selecionar
     */
    public static void selecionar(String coluna,String valor){
        selecao = Conexao.selecionar("SELECT * FROM CLIENTE WHERE "+coluna+" = '"+valor+"';");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Cliente não existe!");
            else{
                while(selecao.next()){
                    System.out.println("CPF:"+selecao.getString(1)+","
                            + "Nome:"+selecao.getString(2)+","
                            + "E-mail:"+selecao.getString(3)+";");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** selecionarTudo
     * seleciona todos os clientes
     */
    public static void selecionarTudo(){
        selecao = Conexao.selecionar("SELECT * FROM CLIENTE;");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Não há clientes cadastrados!");
            else{
                while(selecao.next()){
                    System.out.println("CPF:"+selecao.getString(1)+","
                            + "Nome:"+selecao.getString(2)+","
                            + "E-mail:"+selecao.getString(3)+";");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
