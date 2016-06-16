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
public class ContaDAOTest {
    
    public ContaDAOTest() {
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
     * Test of cadastrar method, of class ContaDAO.
     */
    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        String usuario = "";
        String senha = "";
        String saldo = "";
        String cliente = "";
        ContaDAO.cadastrar(usuario, senha, saldo, cliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class ContaDAO.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        String coluna = "";
        String valor = "";
        ContaDAO.deletar(coluna, valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class ContaDAO.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        String coluna1 = "";
        String valor1 = "";
        String coluna2 = "";
        String valor2 = "";
        ContaDAO.atualizar(coluna1, valor1, coluna2, valor2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecionar method, of class ContaDAO.
     */
    @Test
    public void testSelecionar() {
        System.out.println("selecionar");
        String coluna = "";
        String valor = "";
        ContaDAO.selecionar(coluna, valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecionarTudo method, of class ContaDAO.
     */
    @Test
    public void testSelecionarTudo() {
        System.out.println("selecionarTudo");
        ContaDAO.selecionarTudo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
