package UI;

import Conexao.Conexao;
import DAO.VendaDAO;
import Menus.VendaMenu;
import Verificar.VerificarConta;
import Verificar.VerificarProduto;
import Verificar.VerificarVenda;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Console;

/** VendaUI
 * Interface da Venda
 * @author Guillermo1
 */
public class VendaUI {
    
    /** cadastrar
     * Interface do cadastro da venda
     */
    public static void cadastrar(){
        String conta = Console.scanString("Digite a conta que realizará a compra:");
        if(VerificarVenda.verificar("conta", conta) && VerificarConta.contaExiste("usuario", conta, false, true)){
            ResultSet selecao = Conexao.selecionar("SELECT ID FROM CONTA WHERE NOME = "+conta+";");
            try {
                while(selecao.next())
                    VendaDAO.cadastrar(selecao.getInt(1));
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            VendaMenu.menuProdutos();
        }
    }
    
    /** cadastrarProduto
     * Interface da compra
     */
    public static void cadastrarProduto(){
        String produto = Console.scanString("Digite o nome do produto:");
        if(VerificarProduto.produtoExiste("nome", produto, false, true)){
            String qtd = Console.scanString("Digite a quantidade que quer comprar:");
            if(VerificarVenda.verificar("qtd", qtd))
                VendaDAO.cadastrarProdutos(produto, Integer.parseInt(qtd));
        }
    }
    
    /** deletar
     * Interface da deleção da venda
     */
    public static void deletar(){
        String coluna = Console.scanString("Coluna pelo qual deletar:");
        String valor = Console.scanString(coluna+" a deletar:");
        if(VerificarVenda.verificar(coluna.toLowerCase(), valor) && VerificarVenda.vendaExiste(coluna,valor,false,true))
            VendaDAO.deletar(coluna, valor);
    }
    
    /** atualizar
     * Interface da atualização da venda
     */
    public static void atualizar(){
        String coluna1 = Console.scanString("Coluna a modificar:");
        String valor1 = Console.scanString("Novo "+coluna1+":");
        if(VerificarVenda.verificar(coluna1, valor1)){
            String coluna2 = Console.scanString("Coluna a procurar:");
            String valor2 = Console.scanString(coluna2+" a procurar:");
            if(VerificarVenda.verificar(coluna2, valor2) && VerificarVenda.vendaExiste(coluna2,valor2,false,true))
                VendaDAO.atualizar(coluna1, valor1, coluna2, valor2);
        }
    }
    
    /** selecionar
     * Interface da seleção da venda
     */
    public static void selecionar(){
        String coluna1 = Console.scanString("Coluna a selecionar:");
        String valor1 = Console.scanString(coluna1+" a selecionar:");
        if(VerificarVenda.verificar(coluna1, valor1))
            VendaDAO.selecionar(coluna1, valor1);
    }
}
