package Menus;

import util.Console;

public class Venda_UI {
    
    public static void adicionarProdutos(){
        boolean repetir = true;
        String produto;
        int opcao;
        while(repetir){
            System.out.println("-----------------\n"
                    + "1-Comprar produto"
                    + "2-Finalizar Venda"
                    + "-----------------");
            opcao = Console.scanInt("Digite a opção desejada:");
            switch(opcao){
                case 1:produto = Console.scanString("Digite o nome do produto:");break;
                case 2:repetir = false;break;
            }
        }
    }
    
}