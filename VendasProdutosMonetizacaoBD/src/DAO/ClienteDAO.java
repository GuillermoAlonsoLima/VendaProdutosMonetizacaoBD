package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    private static PreparedStatement stm;
    private static final Connection CON = Conexao.getCon();
    private static ResultSet resultado; 
    
    public void inserirCliente(String cpf,String nome,String email) throws SQLException{
        stm = CON.prepareStatement("SELECT INSERIR_CLIENTE(?,?,?);");
        stm.setString(1, cpf);stm.setString(2, nome);stm.setString(3, email);
        stm.executeUpdate();
    }
    
}