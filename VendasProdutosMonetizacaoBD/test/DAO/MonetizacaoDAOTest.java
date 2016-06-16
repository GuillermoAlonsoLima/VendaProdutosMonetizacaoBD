/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class MonetizacaoDAOTest {
    
    public MonetizacaoDAOTest() {
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
     * Test of logar method, of class MonetizacaoDAO.
     */
    @Test
    public void testLogar() {
        System.out.println("logar");
        String usuario = "";
        String senha = "";
        Integer expResult = null;
        Integer result = MonetizacaoDAO.logar(usuario, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of depositar method, of class MonetizacaoDAO.
     */
    @Test
    public void testDepositar() {
        System.out.println("depositar");
        Integer conta = null;
        String saldo = "";
        MonetizacaoDAO.depositar(conta, saldo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retirar method, of class MonetizacaoDAO.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar");
        Integer conta = null;
        String saldo = "";
        MonetizacaoDAO.retirar(conta, saldo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transferir method, of class MonetizacaoDAO.
     */
    @Test
    public void testTransferir() {
        System.out.println("transferir");
        Integer conta = null;
        String usuario = "";
        String saldo = "";
        MonetizacaoDAO.transferir(conta, usuario, saldo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of visualizarSaldo method, of class MonetizacaoDAO.
     */
    @Test
    public void testVisualizarSaldo() {
        System.out.println("visualizarSaldo");
        Integer conta = null;
        MonetizacaoDAO.visualizarSaldo(conta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
