package Menus;

import DAO.VendaDAO;
import UI.VendaUI;
import util.Console;

/** VendaMenu
 * Possui o menu da venda
 * @author Guillermo1
 */
public class VendaMenu {
    /** menu
     * Menu da Venda
     */
    public static void menu(){
        boolean repetir = true;int opcao;
        while(repetir){
            System.out.println("---------------------\n"
                    + "1-Cadastrar Venda\n"
                    + "2-Deletar Venda\n"
                    + "3-Atualizar Venda\n"
                    + "4-Selecionar Venda\n"
                    + "5-Selecionar todas as Vendas\n"
                    + "6-Voltar\n"
                    + "7-Sair\n"
                    + "---------------------");
            try{
                opcao = Console.scanInt("Digite a opção desejada:");
                switch(opcao){
                    case 1:VendaUI.cadastrar();break;
                    case 2:VendaUI.deletar();break;
                    case 3:VendaUI.atualizar();break;
                    case 4:VendaUI.selecionar();break;
                    case 5:VendaDAO.selecionarTudo();break;
                    case 6:repetir = false;break;
                    case 7:System.exit(0);break;
                    default:System.out.println("Somente de 1 a 7!");break;
                }
            }catch(Exception ex){
                    System.out.println("A opção deve ser um número!");
            }         
        }
    }
    
    /** menuProdutos
     * Menu da compra
     */
    public static void menuProdutos(){
        boolean repetir = true;int opcao;
        while(repetir){
            System.out.println("---------------------\n"
                    + "1-Comprar Produto\n"
                    + "2-Completar Venda\n"
                    + "---------------------");
            try{
                opcao = Console.scanInt("Digite a opção desejada:");
                switch(opcao){
                    case 1:VendaUI.cadastrarProduto();break;
                    case 2:VendaDAO.completarVenda();repetir = false;break;
                    default:System.out.println("Somente 1 ou 2!");break;
                }
            }catch(Exception ex){
                System.out.println("A opção deve ser um número!");
            }
        }
    }
}
