package UI;

import DAO.RelatoriosDAO;
import Verificar.VerificarConta;
import util.Console;

/** RelatoriosUI
 * Possui interface dos relatorios
 * @author Guillermo1
 */
public class RelatoriosUI {

    /** comprasConta
     * Interface das compras da conta
     */
    public static void comprasConta(){
        String conta = Console.scanString("Digite a conta que quer verificar as compras:");
        if(VerificarConta.verificar("usuario", conta) && VerificarConta.contaExiste("usuario", conta, false, true))
            RelatoriosDAO.comprasConta(conta);
    }
}
