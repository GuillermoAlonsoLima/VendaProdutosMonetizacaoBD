package UI;

import DAO.ContaDAO;
import Verificar.VerificarCliente;
import Verificar.VerificarConta;
import util.Console;

/** ContaUI
 * Interface da Conta
 * @author Guillermo1
 */
public class ContaUI {
    
    /** cadastrar
     * Interface do cadastro da conta
     */
    public static void cadastrar(){
        String usuario = Console.scanString("Digite o usuario:");
        if(VerificarConta.verificar("usuario", usuario) && !VerificarConta.contaExiste("usuario", usuario, true, false)){
            String senha = Console.scanString("Digite a senha:");
            if(VerificarConta.verificar("senha", senha)){
                String saldo = Console.scanString("Digite o saldo:");
                if(VerificarConta.verificar("saldo", saldo)){
                    String cliente = Console.scanString("Digite o cpf do dono desta conta:");
                    if(VerificarConta.verificar("cliente", cliente) && VerificarCliente.clienteExiste("cpf", cliente, false, true))
                        ContaDAO.cadastrar(usuario, senha, saldo, cliente);
                }
            }
        }
    }
    
    /** deletar
     * Interface da deleção da conta
     */
    public static void deletar(){
        String coluna = Console.scanString("Coluna pelo qual deletar:");
        String valor = Console.scanString(coluna+" a deletar:");
        if(VerificarConta.verificar(coluna.toLowerCase(), valor) && VerificarConta.contaExiste(coluna,valor,false,true))
            ContaDAO.deletar(coluna, valor);
    }
    
    /** atualizar
     * Interface da atualização da conta
     */
    public static void atualizar(){
        String coluna1 = Console.scanString("Coluna a modificar:");
        String valor1 = Console.scanString("Novo "+coluna1+":");
        if(VerificarConta.verificar(coluna1, valor1)){
            String coluna2 = Console.scanString("Coluna a procurar:");
            String valor2 = Console.scanString(coluna2+" a procurar:");
            if(VerificarConta.verificar(coluna2, valor2) && VerificarConta.contaExiste(coluna2,valor2,false,true))
                ContaDAO.atualizar(coluna1, valor1, coluna2, valor2);
        }
    }
    
    /** selecionar
     * Interface da seleção da conta
     */
    public static void selecionar(){
        String coluna1 = Console.scanString("Coluna a selecionar:");
        String valor1 = Console.scanString(coluna1+" a selecionar:");
        if(VerificarConta.verificar(coluna1, valor1))
            ContaDAO.selecionar(coluna1, valor1);
    }
    
}
