package UI;

import DAO.ClienteDAO;
import Verificar.VerificarCliente;
import util.Console;

/** ClienteUI
 * Interface do Cliente
 * @author Guillermo1
 */
public class ClienteUI {
    
    /** cadastrar
     * Interface do cadastro do cliente
     */
    public static void cadastrar(){
        String cpf = Console.scanString("Digite o cpf:");
        if(VerificarCliente.verificar("cpf", cpf) && !VerificarCliente.clienteExiste("cpf",cpf,true,false)){
            String nome = Console.scanString("Digite o nome:");
            if(VerificarCliente.verificar("nome", nome)){
                String email = Console.scanString("Digite o e-mail:");
                if(VerificarCliente.verificar("email", email))
                    ClienteDAO.cadastrar(cpf, nome, email);
            }
        }
    }
    
    /** deletar
     * Interface da deleção do cliente
     */
    public static void deletar(){
        String coluna = Console.scanString("Coluna pelo qual deletar:");
        String valor = Console.scanString(coluna+" a deletar:");
        if(VerificarCliente.verificar(coluna.toLowerCase(), valor) && VerificarCliente.clienteExiste(coluna,valor,false,true))
            ClienteDAO.deletar(coluna, valor);
    }
    
    /** atualizar
     * Interface da atualização do cliente
     */
    public static void atualizar(){
        String coluna1 = Console.scanString("Coluna a modificar:");
        String valor1 = Console.scanString("Novo "+coluna1+":");
        if(VerificarCliente.verificar(coluna1, valor1)){
            String coluna2 = Console.scanString("Coluna a procurar:");
            String valor2 = Console.scanString(coluna2+" a procurar:");
            if(VerificarCliente.verificar(coluna2, valor2) && VerificarCliente.clienteExiste(coluna2,valor2,false,true))
                ClienteDAO.atualizar(coluna1, valor1, coluna2, valor2);
        }
    }
    
    /** selecionar
     * Interface da seleção do cliente
     */
    public static void selecionar(){
        String coluna1 = Console.scanString("Coluna a selecionar:");
        String valor1 = Console.scanString(coluna1+" a selecionar:");
        if(VerificarCliente.verificar(coluna1, valor1))
            ClienteDAO.selecionar(coluna1, valor1);
    }

}
