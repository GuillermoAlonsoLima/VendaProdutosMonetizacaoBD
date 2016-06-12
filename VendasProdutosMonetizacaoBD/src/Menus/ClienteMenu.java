/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import DAO.ClienteDAO;
import UI.ClienteUI;
import util.Console;

/** ClienteMenu
 * Possui o menu do cliente
 * @author Guillermo1
 */
public class ClienteMenu {

    /** menu
     * Menu do Cliente
     */
    public static void menu(){
        boolean repetir = true;int opcao;
        while(repetir){
            System.out.println("---------------------\n"
                    + "1-Cadastrar Cliente\n"
                    + "2-Deletar Cliente\n"
                    + "3-Atualizar Cliente\n"
                    + "4-Selecionar Cliente\n"
                    + "5-Selecionar todos os Clientes\n"
                    + "6-Voltar\n"
                    + "7-Sair\n"
                    + "---------------------");
            try{
                opcao = Console.scanInt("Digite a opção desejada:");
                switch(opcao){
                    case 1:ClienteUI.cadastrar();break;
                    case 2:ClienteUI.deletar();break;
                    case 3:ClienteUI.atualizar();break;
                    case 4:ClienteUI.selecionar();break;
                    case 5:ClienteDAO.selecionarTudo();break;
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
