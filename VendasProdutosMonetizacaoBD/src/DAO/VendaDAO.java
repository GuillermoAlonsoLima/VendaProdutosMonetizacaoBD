package DAO;

import Conexao.Conexao;
import Util.DateUtil;
import java.sql.ResultSet;
import java.sql.SQLException;

/** VendaDAO
 * Executa comandos sql relacionados a tabela Venda.
 * @author Guillermo1
 */
public class VendaDAO {
    private static ResultSet selecao;
    private static int venda_atual;
    /** cadastrar
     * Cadastra a venda
     * @param conta
     */
    public static void cadastrar(int conta){        
        Conexao.executar("INSERT INTO VENDA(DATA_HORA,CONTA) VALUES(CURRENT_TIMESTAMP,"+conta+";");
        selecao = Conexao.selecionar("SELECT MAX(ID) FROM VENDA;");
        try{    
            while(selecao.next())
                venda_atual = selecao.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** cadastrarProdutos
     * Cadastra os produtos da venda
     * @param produto
     * @param qtd
     */
    public static void cadastrarProdutos(String produto,int qtd){
        selecao = Conexao.selecionar("SELECT ID FROM PRODUTO WHERE NOME = "+produto+";");
        try {
            while(selecao.next())
                Conexao.executar("INSERT INTO VENDA_PRODUTO VALUES("+venda_atual+","+selecao.getInt(1)+","+qtd+");");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** deletar
     * Deleta a venda
     * @param coluna referencia para deletar
     * @param valor valor de referencia para deletar
     */
    public static void deletar(String coluna,String valor){
        Conexao.executar("DELETE FROM VENDA WHERE "+coluna+" = '"+valor+"';");
    }
    
    /** atualizar
     * atualiza a venda
     * @param coluna1 coluna a atualizar
     * @param valor1 novo valor da coluna
     * @param coluna2 referencia para atualizar
     * @param valor2 valor da referencia para atualizar
     */
    public static void atualizar(String coluna1,String valor1,String coluna2,String valor2){
        Conexao.executar("UPDATE VENDA SET "+coluna1+" = '"+valor1+"' WHERE "+coluna2+" = '"+valor2+"';");
    }    
    
    /** selecionar
     * seleciona a venda
     * @param coluna coluna a selecionar
     * @param valor valor a selecionar
     */
    public static void selecionar(String coluna,String valor){
        selecao = Conexao.selecionar("SELECT V.*,C.USUARIO FROM VENDA V ON V."+coluna+" = '"+valor+"'"
                + "JOIN CONTA C ON C.ID = V.CONTA;");
        ResultSet selecao_produtos;
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Venda não existe!");
            else{
                while(selecao.next()){
                    System.out.println("ID:"+selecao.getInt(1)+","
                            + "Data e Hora:"+DateUtil.dateHourToString(selecao.getDate(2))+","
                            + "Conta:"+selecao.getString(4)+";");
                    selecao_produtos = Conexao.selecionar("SELECT * FROM PRODUTO"
                            + "JOIN PRODUTO_VENDA PV ON P.ID = PV.PRODUTO"
                            + "JOIN VENDA V ON PV.VENDA = V.ID AND V.ID = "+selecao.getInt(1)+";");
                    System.out.println("Produtos:");
                    while(selecao_produtos.next()){
                        System.out.println("ID:"+selecao_produtos.getInt(1)+","
                            + "Nome:"+selecao_produtos.getString(2)+","
                            + "Preço:"+selecao_produtos.getDouble(3)+";");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** selecionarTudo
     * seleciona todos as vendas
     */
    public static void selecionarTudo(){
        selecao = Conexao.selecionar("SELECT V.*,C.USUARIO FROM VENDA V"
                + "JOIN CONTA C ON C.ID = V.CONTA;");
        ResultSet selecao_produtos;
        try {
            if(!selecao.isBeforeFirst())
                System.out.println("Não há vendas cadastradas!");
            else{
                while(selecao.next()){
                    System.out.println("ID:"+selecao.getInt(1)+","
                            + "Data e Hora:"+DateUtil.dateHourToString(selecao.getDate(2))+","
                            + "Conta:"+selecao.getString(4)+";");
                    selecao_produtos = Conexao.selecionar("SELECT P.*,PV.QTD FROM PRODUTO P"
                            + "JOIN PRODUTO_VENDA PV ON P.ID = PV.PRODUTO"
                            + "JOIN VENDA V ON PV.VENDA = V.ID AND V.ID = "+selecao.getInt(1)+";");
                    System.out.println("Produtos:");
                    while(selecao_produtos.next()){
                        System.out.println("ID:"+selecao_produtos.getInt(1)+","
                            + "Nome:"+selecao_produtos.getString(2)+","
                            + "Preço:"+selecao_produtos.getDouble(3)+";");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /** completarVenda
     * Verifica se houve algum produto comprado na venda, se não será eliminada
     */
    public static void completarVenda(){
        selecao = Conexao.selecionar("SELECT PV.* FROM PRODUTO_VENDA PV"
                + "JOIN VENDA V ON V.ID = PV.VENDA AND PV.VENDA = "+venda_atual+";");
        try{
            if(!selecao.isBeforeFirst()){
                System.out.println("Nenhum produto comprado!");
                Conexao.executar("DELETE FROM VENDA WHERE ID = "+venda_atual+";");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
