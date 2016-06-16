/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verificar;

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
public class VerificarContaTest {
    
    public VerificarContaTest() {
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
     * Test of verificar method, of class VerificarConta.
     */
    @Test
    public void testVerificar() {
        System.out.println("verificar");
        String coluna = "";
        String valor = "";
        boolean expResult = false;
        boolean result = VerificarConta.verificar(coluna, valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contaExiste method, of class VerificarConta.
     */
    @Test
    public void testContaExiste() {
        System.out.println("contaExiste");
        String coluna = "";
        String valor = "";
        boolean falar_existe = false;
        boolean falar_nao_existe = false;
        boolean expResult = false;
        boolean result = VerificarConta.contaExiste(coluna, valor, falar_existe, falar_nao_existe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
