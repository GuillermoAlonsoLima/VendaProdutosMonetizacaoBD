package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {
    private static PreparedStatement stm;
    private static final Connection CON = Conexao.getCon();
    private static ResultSet resultado; 
    
    public static void inserirConta(String usuario,double saldo,int cliente) throws SQLException{
        stm = CON.prepareStatement("SELECT INSERIR_CONTA(?,?,?);");
        stm.setString(1, usuario);stm.setDouble(2, saldo);stm.setInt(3, cliente);
        stm.executeUpdate();
    }
    
    public static int verificarConta(String usuario) throws SQLException{
        stm = CON.prepareStatement("SELECT CODIGO FROM CONTA WHERE USUARIO = ?;");
        stm.setString(1, usuario);
        resultado = stm.executeQuery();
        while(resultado.next()){
            return resultado.getInt(1);
        }
        return 0;
    }
    
    public static void Depositar(){
        
    }
    
    public static void Retirar(){
        
    }
    
}