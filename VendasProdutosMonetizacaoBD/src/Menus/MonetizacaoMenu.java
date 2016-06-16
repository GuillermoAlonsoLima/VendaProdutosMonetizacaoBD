package Menus;

import DAO.MonetizacaoDAO;
import UI.MonetizacaoUI;
import util.Console;

/** MonetizacaoMenu
 * Possui o menu da monetizacao
 * @author Guillermo1
 */
public class MonetizacaoMenu {
    private static Integer conta_logada;
    public static void menu(){
        boolean repetir = true;int opcao;
        while(repetir){
            System.out.println("---------------------\n"
                    + "1-Depositar\n"
                    + "2-Retirar\n"
                    + "3-Transferir\n"
                    + "4-Visualizar Saldo\n"
                    + "5-Comprar\n"
                    + "6-Voltar\n"
                    + "7-Sair\n"
                    + "---------------------");
            try{
                opcao = Console.scanInt("Digite a opção desejada:");
                switch(opcao){
                    case 1:MonetizacaoUI.depositar(conta_logada);break;
                    case 2:MonetizacaoUI.retirar(conta_logada);break;
                    case 3:MonetizacaoUI.transferir(conta_logada);break;
                    case 4:MonetizacaoDAO.visualizarSaldo(conta_logada);
                    case 5:MonetizacaoUI.comprar(conta_logada);break;
                    case 6:repetir = false;break;
                    case 7:System.exit(0);break;
                    default:System.out.println("Somente de 1 a 7!");break;
                }
            }catch(Exception ex){
                    System.out.println("A opção deve ser um número!");
            }         
        }
    }
    
    public static boolean setConta_logada(Integer conta_logada){
        if(conta_logada != null){
            MonetizacaoMenu.conta_logada = conta_logada;return true;
        }else
            return false;
    }
    
}
