/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

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
public class MonetizacaoMenuTest {
    
    public MonetizacaoMenuTest() {
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
     * Test of menu method, of class MonetizacaoMenu.
     */
    @Test
    public void testMenu() {
        System.out.println("menu");
        MonetizacaoMenu.menu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setConta_logada method, of class MonetizacaoMenu.
     */
    @Test
    public void testSetConta_logada() {
        System.out.println("setConta_logada");
        Integer conta_logada = null;
        boolean expResult = false;
        boolean result = MonetizacaoMenu.setConta_logada(conta_logada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
