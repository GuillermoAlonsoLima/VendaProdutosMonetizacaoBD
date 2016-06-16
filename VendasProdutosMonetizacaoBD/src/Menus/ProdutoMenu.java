package Menus;

import DAO.ProdutoDAO;
import UI.ProdutoUI;
import util.Console;

/** ProdutoMenu
 * Possui o menu do produto
 * @author Guillermo1
 */
public class ProdutoMenu {
    public static void menu(){
        boolean repetir = true;int opcao;
        while(repetir){
            System.out.println("---------------------\n"
                    + "1-Cadastrar Produto\n"
                    + "2-Deletar Produto\n"
                    + "3-Atualizar Produto\n"
                    + "4-Selecionar Produto\n"
                    + "5-Selecionar todas as Produtos\n"
                    + "6-Voltar\n"
                    + "7-Sair\n"
                    + "---------------------");
            try{
                opcao = Console.scanInt("Digite a opção desejada:");
                switch(opcao){
                    case 1:ProdutoUI.cadastrar();break;
                    case 2:ProdutoUI.deletar();break;
                    case 3:ProdutoUI.atualizar();break;
                    case 4:ProdutoUI.selecionar();break;
                    case 5:ProdutoDAO.selecionarTudo();break;
                    case 6:repetir = false;break;
                    case 7:System.exit(0);break;
                    default:System.out.println("Somente de 1 a 7!");break;
                }
            }catch(Exception ex){
                    System.out.println("A opção deve ser um número!");
            }         
        }
    }
}
