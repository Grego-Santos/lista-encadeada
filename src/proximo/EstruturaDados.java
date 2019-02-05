/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proximo;

import java.util.Scanner;

/**
 *
 * @author humbe
 */
public class EstruturaDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        //System.out.printf("A lista tem %d elementos. Eis a lista:\n\n", lista.getQtdNodes());
        //lista.imprimeLista();

        lista.insertNode("Primeiro", 1);
        lista.insertNode("Segundo", 2);
        lista.insertNode("Terceiro", 3);
        lista.insertNode("Quarto", 4);
        lista.insertNode("Quinto", 5);
        lista.insertNode("Sexto", 6);
        lista.insertNode("Sétimo", 7);
        lista.insertNode("Oitavo", 8);
        
        /*lista.insertNode("Sétimo", 7);
        lista.insertNode("Quarto", 4);
        lista.insertNode("Terceiro", 3);
        lista.insertNode("Segundo", 2);
        lista.insertNode("Sexto", 6);
        lista.insertNode("Oitavo", 8);
        lista.insertNode("Quinto", 5);
        lista.insertNode("Primeiro", 1);*/
        
        System.out.printf("A lista tem %d elementos. Eis a lista:\n\n", lista.getSize());
        lista.show1();
        
        int i = 0;
        do {
            
        
            
        } while ( i < 10);
        
        /*System.out.println("Delete last");
        lista.deleteLastNode();
        lista.show1();*/
        
        /*System.out.println("Delete first");
        lista.deleteFirstNode();
        lista.show1();*/
        
        /*System.out.println("Delete posição");
        Scanner leia = new Scanner(System.in);
        int valor = 2;
        //System.out.println("Digite uma posição para excluir: ");
        //valor = leia.nextInt();
        lista.deleteByIndex(valor);
        lista.show1();
        i++;*/
        
        /*System.out.println("Insere primeiro");
        lista.insertNodeFirst("Batata", 99, false);
        lista.show();*/
        
        /*System.out.println("Insere qualquer");
        lista.insertNodeByIndex("NOVO", 69, 4, true);
        lista.show();*/
        
        /*System.out.println("Swap: adjacente");
        lista.swapAdjacent(4);
        lista.show();*/
        
        /*System.out.println("Swap: arbitrário");
        lista.swapArbitrary(1, 8);
        lista.show();*/
        
        /*int index = 8,
            id    = 2;
        String mensagem = "Oitavo";
        
        System.out.println("Search by: index [" + index + "]");
        System.out.println(lista.getNodeByIndex(index).toString());
        
        System.out.println("Search by: mensagem [" + mensagem + "]");
        System.out.println(lista.searchByMessage(mensagem).toString() + " batata");
        
        System.out.println("Search by: id [" + id + "]");
        System.out.println(lista.searchById(id).toString());*/
        
        System.out.println(" -- Bubble sort --");
        lista.bubbleSort1();
    }
}
