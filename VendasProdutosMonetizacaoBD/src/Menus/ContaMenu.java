package Menus;

import DAO.ContaDAO;
import UI.ContaUI;
import util.Console;

/** ContaMenu
 * Possui o menu da conta
 * @author Guillermo1
 */
public class ContaMenu {
    public static void menu(){
        boolean repetir = true;int opcao;
        while(repetir){
            System.out.println("---------------------\n"
                    + "1-Cadastrar Conta\n"
                    + "2-Deletar Conta\n"
                    + "3-Atualizar Conta\n"
                    + "4-Selecionar Conta\n"
                    + "5-Selecionar todas as Contas\n"
                    + "6-Voltar\n"
                    + "7-Sair\n"
                    + "---------------------");
            try{
                opcao = Console.scanInt("Digite a opção desejada:");
                switch(opcao){
                    case 1:ContaUI.cadastrar();break;
                    case 2:ContaUI.deletar();break;
                    case 3:ContaUI.atualizar();break;
                    case 4:ContaUI.selecionar();break;
                    case 5:ContaDAO.selecionarTudo();break;
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
