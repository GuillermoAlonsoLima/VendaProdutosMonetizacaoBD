package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatoriosDAO {
    private static PreparedStatement stm;
    private static final Connection CON = Conexao.getCon();
    private static ResultSet resultado,resultado2; 
    
    public static void produtosVendidos() throws SQLException{
        stm = CON.prepareStatement("SELECT P.NOME,V.DATA_VENDA,C.USUARIO FROM VENDAS_PRODUTOS VP"
                + "JOIN PRODUTO P ON VP.PRODUTO = P.CODIGO"
                + "JOIN VENDA V ON VP.VENDA = V.CODIGO"
                + "JOIN CONTA C ON V.COMPRADOR = C.CODIGO;");
        resultado = stm.executeQuery();        
        while(resultado.next()){
            System.out.println("Produto:"+resultado.getString(1)+","
                    + "Data da Venda:"+resultado.getString(2)+","
                    + "Comprador:"+resultado.getString(3)+";");
        }
    }
    
    public static void comprasCliente(String cliente) throws SQLException{
        stm = CON.prepareStatement("SELECT P.*,V.DATA_VENDA FROM CLIENTE CL"
                + "JOIN CONTA CO ON CO.CLIENTE = CL.CPF AND CL.NOME = ?"
                + "JOIN VENDA V ON V.CONTA = CO.CODIGO"
                + "JOIN VENDAS_PRODUTOS VP ON VP.VENDA = V.CODIGO"
                + "JOIN PRODUTO P ON P.CODIGO = VP.PRODUTO;");
        stm.setString(1, cliente);
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Código:"+resultado.getInt(1)+","
                    + "Nome:"+resultado.getString(2)+","
                    + "Preço:"+resultado.getDouble(3)+","
                    + "Data da Venda:"+resultado.getString(5)+";");
        }
    }
    
    public static void comprasConta(String conta) throws SQLException{
        stm = CON.prepareStatement("SELECT P.*,V.DATA_VENDA FROM CONTA CO"
                + "JOIN VENDA V ON V.COMPRADOR = CO.CODIGO AND CO.NOME = ?"
                + "JOIN VENDAS_PRODUTOS VP ON VP.VENDA = V.CODIGO"
                + "JOIN PRODUTO P ON P.CODIGO = VP.PRODUTO;");
        stm.setString(1, conta);
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Código:"+resultado.getInt(1)+","
                    + "Nome:"+resultado.getString(2)+","
                    + "Preço:"+resultado.getDouble(3)+","
                    + "Data da Venda:"+resultado.getString(5)+";");
        }
    }
    
    public static void clientesMaisCompram() throws SQLException{
        stm = CON.prepareStatement("SELECT CL.NOME,COUNT(VP.VENDA) FROM CLIENTE CL"
                + "JOIN CONTA CO ON CO.CLIENTE = CL.CPF"
                + "JOIN VENDA V ON V.COMPRADOR = CO.CODIGO"
                + "JOIN VENDAS_PRODUTOS VP ON VP.VENDA = V.CODIGO"
                + "GROUP BY CL.NOME"
                + "ORDER BY COUNT(VP.VENDA) DESC;");
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Cliente:"+resultado.getString(1)+","
                    + "Numero de Compras:"+resultado.getInt(2)+";");
        }
    }
    
    public static void clientesMaisMonetizam() throws SQLException{
        stm = CON.prepareStatement("SELECT CL.NOME,COUNT(CM.CONTA_TRANSFERIDOR) FROM CLIENTE CL"
                + "JOIN CONTA CO ON CO.CLIENTE = CL.CPF"
                + "JOIN CONTA_MONETIZACAO CM ON CO.CODIGO = CM.CONTA_TRANSFERIDOR"
                + "GROUP BY CL.NOME"
                + "ORDER BY COUNT(CM.CONTA_TRANSFERIDOR) DESC;");
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Cliente:"+resultado.getString(1)+","
                    + "Monetizações:"+resultado.getInt(2)+";");
        }
    }
    
    public static void contasMaisCompram() throws SQLException{
        stm = CON.prepareStatement("SELECT CO.NOME,CL.NOME,COUNT(VP.VENDA) FROM CLIENTE CL"
                + "JOIN CONTA CO ON CO.CLIENTE = CL.CPF"
                + "JOIN VENDA V ON V.COMPRADOR = CO.CODIGO"
                + "JOIN VENDAS_PRODUTOS VP ON VP.VENDA = V.CODIGO"
                + "GROUP BY CO.NOME"
                + "ORDER BY COUNT(VP.VENDA) DESC;");
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Conta:"+resultado.getString(1)+","
                    + "Cliente"+resultado.getString(2)+","
                    + "Numero de Compras:"+resultado.getInt(3)+";");
        }
    }
    
    public static void contasMaisMonetizam() throws SQLException{
        stm = CON.prepareStatement("SELECT CO.NOME,CL.NOME,COUNT(CM.CONTA_TRANSFERIDOR) FROM CLIENTE CL"
                + "JOIN CONTA CO ON CO.CLIENTE = CL.CPF"
                + "JOIN CONTA_MONETIZACAO CM ON CO.CODIGO = CM.CONTA_TRANSFERIDOR"
                + "GROUP BY CO.NOME"
                + "ORDER BY COUNT(CM.CONTA_TRANSFERIDOR) DESC;");
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Conta:"+resultado.getString(1)+","
                    + "Cliente"+resultado.getString(2)+","
                    + "Monetizações:"+resultado.getInt(3)+";");
        }
    }
    
    public static void clientes() throws SQLException{
        stm = CON.prepareStatement("SELECT * FROM CLIENTES;");
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("CPF:"+resultado.getString(1)+","
                    + "Nome:"+resultado.getString(2)+","
                    + "E-mail:"+resultado.getString(3)+";");
        }
    }
    
    public static void contas() throws SQLException{
        stm = CON.prepareStatement("SELECT CO.*,CL.NOME FROM CONTAS CO"
                + "JOIN CLIENTE ON CL.CPF = CO.CLIENTE;");
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Código:"+resultado.getInt(1)+","
                    + "Usuário:"+resultado.getString(2)+","
                    + "Saldo:"+resultado.getDouble(3)+","
                    + "Cliente:"+resultado.getString(5)+";");
        }
    }
    
    public static void produtos() throws SQLException{
        stm = CON.prepareStatement("SELECT * FROM PRODUTO;");
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Código:"+resultado.getInt(1)+","
                    + "Nome:"+resultado.getString(2)+","
                    + "Preço:"+resultado.getDouble(3)+","
                    + "Quantidade:"+resultado.getInt(4)+";");
        }
    }
    
    public static void vendas() throws SQLException{
        int venda = 1;
        stm = CON.prepareStatement("SELECT * FROM VENDAS V"
                + "JOIN CONTA C ON C.CODIGO = V.COMPRADOR;");
        resultado = stm.executeQuery();
        while(resultado.next()){
            System.out.println("Código:"+resultado.getInt(1)+","
                    + "Valor:"+resultado.getDouble(2)+","
                    + "Data:"+resultado.getString(3)+";");
            produtosVenda(venda);
            venda++;
        }
    }
    
    public static void produtosVenda(int venda) throws SQLException{
        System.out.println("Produtos:");
        stm = CON.prepareStatement("SELECT P.CODIGO,P.NOME,P.PRECO FROM PRODUTO P"
                + "JOIN VENDAS_PRODUTOS VP ON P.CODIGO = VP.PRODUTO AND VP.VENDA = ?;");
        stm.setInt(1, venda);
        resultado2 = stm.executeQuery();
        while(resultado2.next()){
            System.out.println("Código:"+resultado2.getInt(1)+","
                    + "Nome:"+resultado2.getString(2)+","
                    + "Preço:"+resultado2.getDouble(3)+";");
        }
        System.out.println("");
    }
    
}