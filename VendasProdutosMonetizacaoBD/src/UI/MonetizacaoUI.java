package UI;

import DAO.MonetizacaoDAO;
import DAO.VendaDAO;
import Menus.MonetizacaoMenu;
import Menus.VendaMenu;
import Verificar.VerificarConta;
import util.Console;

/** MonetizacaoUI
 * Interface da monetizacao
 * @author Guillermo1
 */
public class MonetizacaoUI {
    
    /** logar
     * Menu do login
     */
    public static void logar(){
        String usuario = Console.scanString("Digite o usuario:");
        if(VerificarConta.verificar("usuario", usuario)){
            String senha = Console.scanString("Digite a senha:");
            if(VerificarConta.verificar("senha", senha)){
                if(MonetizacaoMenu.setConta_logada(MonetizacaoDAO.logar(usuario, senha))){
                    System.out.println("Login foi um sucesso!");
                    MonetizacaoMenu.menu();
                }
            }
        }
    }
    
    /** depositar
     * menu do deposito
     * @param conta
     */
    public static void depositar(Integer conta){
        String saldo = Console.scanString("Digite o valor a depositar:");
        if(VerificarConta.verificar("saldo", saldo))
            MonetizacaoDAO.depositar(conta, saldo);
    }
    
    /** retirar
     * menu da retirada
     * @param conta
     */
    public static void retirar(Integer conta){
        String saldo = Console.scanString("Digite o valor a retirar:");
        if(VerificarConta.verificar("saldo", saldo))
            MonetizacaoDAO.retirar(conta, saldo);
    }
    
    /** transferir
     * menu da transferencia
     * @param conta
     */
    public static void transferir(Integer conta){
        String saldo = Console.scanString("Digite o valor a transferir:");
        if(VerificarConta.verificar("saldo", saldo)){
            String usuario = Console.scanString("Digite o usuario da conta a transferir:");
            if(VerificarConta.verificar("usuario", usuario) && VerificarConta.contaExiste("usuario", usuario, false, true))
                MonetizacaoDAO.transferir(conta, usuario, saldo);
        }
    }
    
    /** comprar
     * Interface das compras
     * @param conta
     */
    public static void comprar(Integer conta){
        VendaDAO.cadastrar(conta);
        VendaMenu.menuProdutos();
    }
    
}
