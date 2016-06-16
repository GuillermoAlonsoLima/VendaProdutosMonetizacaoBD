/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.ProdutoDAO;
import Verificar.VerificarProduto;
import util.Console;

/** ProdutoUI
 * Interface do Produto
 * @author Guillermo1
 */
public class ProdutoUI {

    /** cadastrar
     * Interface do cadastro do produto
     */
    public static void cadastrar() {
        String nome = Console.scanString("Digite o nome do produto:");
        if(VerificarProduto.verificar("nome", nome) && !VerificarProduto.produtoExiste("nome", nome, true, false)){
            String preco = Console.scanString("Digite o preço do produto:");
            if(VerificarProduto.verificar("preco", preco))
                ProdutoDAO.cadastrar(nome, preco);
        }
    }

    /** deletar
     * Interface da deleção do produto
     */
    public static void deletar(){
        String coluna = Console.scanString("Coluna pelo qual deletar:");
        String valor = Console.scanString(coluna+" a deletar:");
        if(VerificarProduto.verificar(coluna.toLowerCase(), valor) && VerificarProduto.produtoExiste(coluna,valor,false,true))
            ProdutoDAO.deletar(coluna, valor);
    }
    
    /** atualizar
     * Interface da atualização do produto
     */
    public static void atualizar(){
        String coluna1 = Console.scanString("Coluna a modificar:");
        String valor1 = Console.scanString("Novo "+coluna1+":");
        if(VerificarProduto.verificar(coluna1, valor1)){
            String coluna2 = Console.scanString("Coluna a procurar:");
            String valor2 = Console.scanString(coluna2+" a procurar:");
            if(VerificarProduto.verificar(coluna2, valor2) && VerificarProduto.produtoExiste(coluna2,valor2,false,true))
                ProdutoDAO.atualizar(coluna1, valor1, coluna2, valor2);
        }
    }
    
    /** selecionar
     * Interface da seleção do produto
     */
    public static void selecionar(){
        String coluna1 = Console.scanString("Coluna a selecionar:");
        String valor1 = Console.scanString(coluna1+" a selecionar:");
        if(VerificarProduto.verificar(coluna1, valor1))
            ProdutoDAO.selecionar(coluna1, valor1);
    }

    
}
