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
    
    public static void depositarSaldo(double saldo,int conta) throws SQLException{
        stm = CON.prepareStatement("UPDATE CONTA SET SALDO = SALDO + ? WHERE CODIGO = ?;"
                + "INSERT INTO CONTA_MONETIZACAO(CONTA_TRANSFERIDOR) VALUES(?);");
        stm.setDouble(1, saldo);stm.setInt(2, conta);stm.setInt(3, conta);
        stm.executeUpdate();
    }
    
    public static void retirarSaldo(int conta,double saldo) throws SQLException{
        stm = CON.prepareStatement("SELECT RETIRAR_SALDO(?,?);"
                + "INSERT INTO CONTA_MONETIZACAO(CONTA_TRANSFERIDOR) VALUES(?);");
        stm.setInt(1, conta);stm.setDouble(2, saldo);stm.setInt(3, conta);
        stm.execute();
    }
    
    public void transferirSaldo(int conta_minha,int conta_outra,double saldo) throws SQLException{
        stm = CON.prepareStatement("SELECT RETIRAR_SALDO(?,?);"
                + "UPDATE CONTA SET SALDO = SALDO + ? WHERE CODIGO = ?;"
                + "INSERT INTO CONTA_MONETIZACAO VALUES(?,?);");
        stm.setInt(1, conta_minha);stm.setDouble(2, saldo);stm.setDouble(3, saldo);stm.setInt(4, conta_outra);
        stm.setInt(5, conta_minha);stm.setInt(6, conta_outra);
        stm.execute();
    }
    
    public Integer visualizarSaldo(int conta) throws SQLException{
        stm = CON.prepareStatement("SELECT SALDO FROM CONTA WHERE CODIGO = ?;");
        stm.setInt(1, conta);
        resultado = stm.executeQuery();
        while(resultado.next()){
            return resultado.getInt(1);
        }
        return null;
    }
    
}