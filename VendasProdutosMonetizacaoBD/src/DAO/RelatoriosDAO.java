package DAO;

import Conexao.Conexao;
import Util.DateUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

/** RelatoriosDAO
 * Possui relatorios
 * @author Guillermo1
 */
public class RelatoriosDAO {
    private static ResultSet selecao;

    /** produtosVendidos
     * mostra os produtos já vendidos
     */
    public static void produtosVendidos(){
        Conexao.selecionar("SELECT P.*,SUM(PV.QTD) FROM PRODUTO P"
                + "JOIN PRODUTO_VENDA PV ON PV.PRODUTO = P.ID"
                + "GROUP BY P.ID"
                + "ORDER BY SUM(P.QTD) DESC;");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Nenhum produto foi vendido!");
            else{
                while(selecao.next()){
                    System.out.println("ID:"+selecao.getInt(1)+","
                                + "Nome:"+selecao.getString(2)+","
                                + "Preço:"+selecao.getDouble(3)+""
                                + "Quantidade:"+selecao.getInt(4)+";");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** comprasConta
     * compras que a conta executou
     * @param conta conta que executou as compras
     */
    public static void comprasConta(String conta){
        selecao = Conexao.selecionar("SELECT ID FROM CONTA WHERE USUARIO = '"+conta+"';");
        ResultSet selecao_venda,selecao_produtos;
        try {
            while(selecao.next()){
                selecao_venda = Conexao.selecionar("SELECT * FROM VENDA WHERE CONTA = "+selecao.getInt(1)+";"); 
                if(!selecao_venda.isBeforeFirst())
                    System.out.println(conta+" não fez nenhuma compra ainda!");
                else{
                    while(selecao_venda.next()){
                        System.out.println("ID:"+selecao_venda.getInt(1)+","
                            + "Data e Hora:"+DateUtil.dateHourToString(selecao_venda.getDate(2))+","
                            + "Conta:"+conta+";");
                        System.out.println("Produtos:");
                        selecao_produtos = Conexao.selecionar("SELECT P.* FROM PRODUTO P"
                                + "JOIN PRODUTO_VENDA PV ON PV.PRODUTO = P.ID"
                                + "JOIN VENDA V ON V.ID = PV.VENDA AND V.ID = "+selecao_venda.getInt(1));
                        while(selecao_produtos.next()){
                            System.out.println("ID:"+selecao_produtos.getInt(1)+","
                            + "Nome:"+selecao_produtos.getString(2)+","
                            + "Preço:"+selecao_produtos.getDouble(3)+";");
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** contaMaisCompra
     * Mostra as contas que mais compram em ordem decrescente
     */
    public static void contaMaisCompra(){
        selecao = Conexao.selecionar("SELECT C.*,COUNT(V.ID) FROM CONTA C"
                + "JOIN VENDA V ON C.ID = V.CONTA"
                + "GROUP BY C.ID"
                + "ORDER BY COUNT(V.ID) DESC;");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Não há contas cadastradas!");
            else{
                while(selecao.next()){
                    System.out.println("ID:"+selecao.getInt(1)+","
                            + "Usuario:"+selecao.getString(2)+","
                            + "Saldo:"+selecao.getString(4)+","
                            + "Cliente:"+selecao.getString(5)+","
                            + "Quantidadede Compras:"+selecao.getInt(6)+";");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** contaMaisMonetiza
     * conta que mais monetiza
     */
    public static void contaMaisMonetiza(){
        selecao = Conexao.selecionar("SELECT C.*,COUNT(M.CONTA),SUM(M.VALOR),DEPOSITO,VALOR_DEPOSITO,RETIRO,VALOR_RETIRO FROM CONTA C"
                + "JOIN MONETIZACAO M ON C.ID = M.CONTA"
                + "JOIN (SELECT COUNT(M.CONTA) AS 'DEPOSITO',M.CONTA AS 'CONTAS_D',SUM(VALOR) AS 'VALOR_DEPOSITO' FROM MONETIZACAO M WHERE M.TIPO = TRUE GROUP BY CONTAS_D) ON CONTAS_D = C.ID"
                + "JOIN (SELECT COUNT(M.CONTA) AS 'RETIRO',M.CONTA AS 'CONTAS_R',SUM(VALOR) AS 'VALOR_RETIRO' FROM MONETIZACAO M WHERE M.TIPO = FALSE GROUP BY CONTAS_R) ON CONTAS_R = C.ID"
                + "GROUP BY C.ID"
                + "ORDER BY COUNT(M.CONTA) DESC;");
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Não há contas cadastradas!");
            else{
                while(selecao.next()){
                    System.out.println("ID:"+selecao.getInt(1)+","
                            + "Usuario:"+selecao.getString(2)+","
                            + "Saldo:"+selecao.getString(4)+","
                            + "Cliente:"+selecao.getString(5)+","
                            + "Monetizações:"+selecao.getInt(6)+","
                            + "Valores Totais:"+selecao.getDouble(7)+","
                            + "Depositos:"+selecao.getInt(8)+","
                            + "Valor depositado:"+selecao.getDouble(9)+","
                            + "Retiros:"+selecao.getInt(10)+","
                            + "Valor retirado:"+selecao.getDouble(11)+";");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
