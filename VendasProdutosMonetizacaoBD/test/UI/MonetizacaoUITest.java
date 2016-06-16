/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

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
public class MonetizacaoUITest {
    
    public MonetizacaoUITest() {
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
     * Test of logar method, of class MonetizacaoUI.
     */
    @Test
    public void testLogar() {
        System.out.println("logar");
        MonetizacaoUI.logar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of depositar method, of class MonetizacaoUI.
     */
    @Test
    public void testDepositar() {
        System.out.println("depositar");
        Integer conta = null;
        MonetizacaoUI.depositar(conta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retirar method, of class MonetizacaoUI.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar");
        Integer conta = null;
        MonetizacaoUI.retirar(conta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transferir method, of class MonetizacaoUI.
     */
    @Test
    public void testTransferir() {
        System.out.println("transferir");
        Integer conta = null;
        MonetizacaoUI.transferir(conta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
