package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection con;
    public static void Conectar(){
        try{
            String url = "jdbc:postgresql://localhost:5432/Monetizacao",usuario = "postgres",senha = "gaat1997";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão foi um sucesso!");
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Conexão falhou!");
        }
    };
    
    public static Connection getCon(){
        return con;
    }
    
}