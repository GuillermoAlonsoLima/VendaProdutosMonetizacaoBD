package Menus;

import DAO.RelatoriosDAO;
import UI.RelatoriosUI;
import util.Console;

/** RelatoriosMenu
 * Possui Menu do relatório
 * @author Guillermo1
 */
public class RelatoriosMenu {
    public static void menu(){
        boolean repetir = true;int opcao;
        while(repetir){
            System.out.println("---------------------\n"
                    + "1-Produtos Vendidos\n"
                    + "2-Compras da Conta\n"
                    + "3-Conta que mais compra\n"
                    + "4-Conta que mais monetiza\n"
                    + "5-Voltar\n"
                    + "6-Sair\n"
                    + "---------------------");
            try{
                opcao = Console.scanInt("Digite a opção desejada:");
                switch(opcao){
                    case 1:RelatoriosDAO.produtosVendidos();break;
                    case 2:RelatoriosUI.comprasConta();break;
                    case 3:RelatoriosDAO.contaMaisCompra();break;
                    case 4:RelatoriosDAO.contaMaisMonetiza();break;
                    case 6:repetir = false;break;
                    case 7:System.exit(0);break;
                    default:System.out.println("Somente de 1 a 6!");break;
                }
            }catch(Exception ex){
                    System.out.println("A opção deve ser um número!");
            }   
        }
    }
}
