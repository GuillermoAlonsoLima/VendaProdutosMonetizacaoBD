package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendaDAO {
    private static PreparedStatement stm;
    private static final Connection CON = Conexao.getCon();
    private static ResultSet resultado; 
    
    public static void inserirVenda(int conta) throws SQLException{
        stm = CON.prepareStatement("SELECT INSERIR_VENDA(?);");
        stm.setInt(1, conta);
    }
    
    public static void inserirProdutos(String produto) throws SQLException{
        stm = CON.prepareStatement("SELECT INSERIR_VENDAS_PRODUTOS(?);");
        stm.setString(1, produto);
    }
    
    public static void completarVenda(int conta) throws SQLException{
        stm = CON.prepareStatement("SELECT COMPLETAR_VENDA(?);");
        stm.setInt(1, conta);
    }
    
}