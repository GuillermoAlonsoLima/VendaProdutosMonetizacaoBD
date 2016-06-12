/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guillermo1
 */
public class ConexaoTest {
    
    public ConexaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of conexao method, of class Conexao.
     */
    @Test
    public void testConexao() {
        System.out.println("conexao");
        Conexao.conexao();
        
    }

    /**
     * Test of executar method, of class Conexao.
     */
    @Test
    public void testExecutar() {
        Conexao.conexao();
        System.out.println("executar");
        String sql = "INSERT INTO CLIENTE VALUES('87576201053','GUILLERMO','guillermoalonso.lima@gmail.com')";
        Conexao.executar(sql);
        
    }

    /**
     * Test of selecionar method, of class Conexao.
     */
    @Test
    public void testSelecionar() {
        Conexao.conexao();
        System.out.println("selecionar");
        String sql = "";
        ResultSet expResult = null;
        ResultSet result = Conexao.selecionar(sql);
        assertEquals(expResult, result);
        
    }
    
}
