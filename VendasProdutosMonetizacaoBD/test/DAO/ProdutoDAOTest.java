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
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
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
     * Test of cadastrar method, of class ProdutoDAO.
     */
    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        String nome = "";
        String preco = "";
        ProdutoDAO.cadastrar(nome, preco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletar method, of class ProdutoDAO.
     */
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        String coluna = "";
        String valor = "";
        ProdutoDAO.deletar(coluna, valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizar method, of class ProdutoDAO.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        String coluna1 = "";
        String valor1 = "";
        String coluna2 = "";
        String valor2 = "";
        ProdutoDAO.atualizar(coluna1, valor1, coluna2, valor2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecionar method, of class ProdutoDAO.
     */
    @Test
    public void testSelecionar() {
        System.out.println("selecionar");
        String coluna = "";
        String valor = "";
        ProdutoDAO.selecionar(coluna, valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecionarTudo method, of class ProdutoDAO.
     */
    @Test
    public void testSelecionarTudo() {
        System.out.println("selecionarTudo");
        ProdutoDAO.selecionarTudo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
