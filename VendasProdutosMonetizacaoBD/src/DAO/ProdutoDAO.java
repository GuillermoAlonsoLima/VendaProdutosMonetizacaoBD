package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    private static PreparedStatement stm;
    private static final Connection CON = Conexao.getCon();
    private static ResultSet resultado; 
    
    public static void inserirProduto(String nome,double preco,int qtd) throws SQLException{
        stm = CON.prepareStatement("SELECT INSERIR_PRODUTOS(?,?,?);");
        stm.setString(1, nome);stm.setDouble(2, preco);stm.setInt(3, qtd);
        stm.execute();
    }
    
    public static void deletarProduto(String nome) throws SQLException{
        stm = CON.prepareStatement("SELECT DELETAR_PRODUTOS(?)");
        stm.setString(1, nome);
        stm.execute();
    }
    
    public static Integer getIDProduto(String nome) throws SQLException{
        stm = CON.prepareStatement("SELECT CODIGO FROM PRODUTO WHERE NOME = $1;");
        resultado = stm.executeQuery();
        while(resultado.next()){
            return resultado.getInt(1);
        }
        return null;
    }
    
}