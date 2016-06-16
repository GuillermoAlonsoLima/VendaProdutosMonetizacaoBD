package DAO;

import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;

/** MonetizacaoDAO
 * Possui métodos de monetização
 * @author Guillermo1
 */
public class MonetizacaoDAO {
    private static ResultSet selecao;     
    
    /** logar
     * Loga a conta de acordo com o usuario e a senha
     * @param usuario
     * @param senha
     * @return O ID da conta logada se correto, nulo se incorreto
     */
    public static Integer logar(String usuario,String senha){
        selecao = Conexao.selecionar("SELECT ID FROM CONTA WHERE USUARIO = '"+usuario+"' AND SENHA = '"+senha+"';");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Usuario e/ou senha errado(s)!");
            else{
                while(selecao.next()){
                    return selecao.getInt(1);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    /** depositar
     * deposita saldo na conta
     * @param conta conta a depositar
     * @param saldo quantia a depositar
     */
    public static void depositar(Integer conta,String saldo){
        Conexao.executar("UPDATE CONTA SET SALDO = SALDO + "+saldo+" WHERE ID = "+conta+";");
    }
    
    /** retirar
     * retira saldo da conta se o saldo depositado for maior ou igual ao retirado
     * @param conta conta a retirar
     * @param saldo quantia a retirar
     */
    public static void retirar(Integer conta,String saldo){
        selecao = Conexao.selecionar("SELECT SALDO FROM CONTA WHERE ID = "+conta+";");
        try {
            while(selecao.next()){
                if(selecao.getDouble(1)<Double.parseDouble(saldo))
                    System.out.println("Saldo insuficiente!");
                else
                    Conexao.executar("UPDATE CONTA SET SALDO = SALDO - "+saldo+" WHERE ID = "+conta+";");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
    }
     
    /** transferir
     * transfere o saldo de uma conta para outra se o saldo depositado for maior ou igual ao retirado
     * @param conta conta a retirar
     * @param usuario conta a depositar
     * @param saldo uantia a transferir
     */
    public static void transferir(Integer conta,String usuario,String saldo){
        selecao = Conexao.selecionar("SELECT SALDO FROM CONTA WHERE ID = "+conta+";");
        try {
            while(selecao.next()){
                if(selecao.getDouble(1)<Double.parseDouble(saldo))
                    System.out.println("Saldo insuficiente!");
                else{
                    Conexao.executar("UPDATE CONTA SET SALDO = SALDO - "+saldo+" WHERE ID = "+conta+";"
                            + "UPDATE CONTA SET SALDO = SALDO + "+saldo+" WHERE USUARIO = '"+usuario+"';");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** visualizarSaldo
     * visualiza o saldo
     * @param conta conta que tera seu saldo visualizado
     */
    public static void visualizarSaldo(Integer conta){
        selecao = Conexao.selecionar("SELECT SALDO FROM CONTA WHERE ID = "+conta+";");
        try {
            while(selecao.next()){
                System.out.println("Saldo:"+selecao.getDouble(1)+";");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
