/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Conexao.Conexao;
import Menus.ClienteMenu;
import util.Console;

/** Menu Principal
 * possui menu inicial
 * @author Guillermo1
 */
public class MenuPrincipal {

    /** menu
     * menu inicial
     */
    public static void menu(){
        Conexao.conexao();
        int opcao;
        while(true){
            System.out.println("---------------------\n"
                    + "1-Cliente\n"
                    + "2-Conta\n"
                    + "3-Produto\n"
                    + "4-Venda\n"
                    + "5-Relatorios\n"
                    + "6-Login\n"
                    + "7-Sair\n"
                    + "---------------------");
            try{
                opcao = Console.scanInt("Digite a opcao desejada:");
                switch(opcao){
                    case 1:ClienteMenu.menu();break;
                    case 7:System.exit(0);break;
                    default:System.out.println("Somente de 1 a 7!");break;
                }
            }catch(Exception ex){
                    System.out.println("A opção deve ser um número!");
            }
        }
    }
}
