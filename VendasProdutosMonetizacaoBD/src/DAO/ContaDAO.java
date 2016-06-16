package DAO;

import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

/** ContaDAO
 * Executa comandos sql relacionados a tabela Conta.
 * @author Guillermo1
 */
public class ContaDAO {
    private static ResultSet selecao;
    
    /** cadastrar
     * Cadastra a conta
     * @param usuario
     * @param senha
     * @param saldo
     * @param cliente
     */
    public static void cadastrar(String usuario,String senha,String saldo,String cliente){
        Conexao.executar("INSERT INTO CONTA(USUARIO,SENHA,SALDO,CLIENTE) VALUES('"+usuario+"','"+senha+"',"+saldo+",'"+cliente+"');");
    }
    
    /** deletar
     * Deleta a conta
     * @param coluna referencia para deletar
     * @param valor valor de referencia para deletar
     */
    public static void deletar(String coluna,String valor){
        Conexao.executar("DELETE FROM CONTA WHERE "+coluna+" = '"+valor+"';");
    }
    
    /** atualizar
     * atualiza a conta
     * @param coluna1 coluna a atualizar
     * @param valor1 novo valor da coluna
     * @param coluna2 referencia para atualizar
     * @param valor2 valor da referencia para atualizar
     */
    public static void atualizar(String coluna1,String valor1,String coluna2,String valor2){
        Conexao.executar("UPDATE CONTA SET "+coluna1+" = '"+valor1+"' WHERE "+coluna2+" = '"+valor2+"';");
    }    
    
    /** selecionar
     * seleciona a conta
     * @param coluna coluna a selecionar
     * @param valor valor a selecionar
     */
    public static void selecionar(String coluna,String valor){
        selecao = Conexao.selecionar("SELECT * FROM CONTA WHERE "+coluna+" = '"+valor+"';");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Conta não existe!");
            else{
                while(selecao.next()){
                    System.out.println("ID:"+selecao.getInt(1)+","
                            + "Usuario:"+selecao.getString(2)+","
                            + "Saldo:"+selecao.getString(4)+","
                            + "Cliente:"+selecao.getString(5)+";");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** selecionarTudo
     * seleciona todos as contas
     */
    public static void selecionarTudo(){
        selecao = Conexao.selecionar("SELECT * FROM CONTA;");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Não há contas cadastradas!");
            else{
                while(selecao.next()){
                    System.out.println("ID:"+selecao.getInt(1)+","
                            + "Usuario:"+selecao.getString(2)+","
                            + "Saldo:"+selecao.getString(4)+","
                            + "Cliente:"+selecao.getString(5)+";");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
}
