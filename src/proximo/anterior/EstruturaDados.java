/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proximo.anterior;

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
        
        /*lista.insertNode("Primeiro", 1);
        lista.insertNode("Segundo", 2);
        lista.insertNode("Terceiro", 3);
        lista.insertNode("Quarto", 4);
        lista.insertNode("Quinto", 5);
        lista.insertNode("Sexto", 6);
        lista.insertNode("Sétimo", 7);
        lista.insertNode("Oitavo", 8);*/
        
        for (int i = 1; i <= 10; i++) {
            lista.insertNode("♦", i);
        }
        
//        lista.showSwapArbitrary(1,2);
//        lista.showSwapArbitrary(1,3);
//        lista.showSwapArbitrary(1,4);
//        lista.showSwapArbitrary(9,10);
//        lista.showSwapArbitrary(8,10);
//        lista.showSwapArbitrary(7,10);
//        lista.showSwapArbitrary(4,5);
//        lista.showSwapArbitrary(4,6);
//        lista.showSwapArbitrary(1,10);
//        lista.showSwapArbitrary(2,10);
//        lista.showSwapArbitrary(1,9);
//        lista.showSwapArbitrary(2,9);

        lista.swapArbitrary(1,2);
        lista.swapArbitrary(1,3);
        lista.swapArbitrary(1,4);
        lista.swapArbitrary(9,10);
        lista.swapArbitrary(8,10);
        lista.swapArbitrary(7,10);
        lista.swapArbitrary(4,5);
        lista.swapArbitrary(4,6);
        lista.swapArbitrary(1,10);
        lista.swapArbitrary(2,10);
        lista.swapArbitrary(1,9);
        lista.swapArbitrary(2,9);
        
        lista.showSelectSort();
        lista.showListDirect();
        lista.showListReverse();
    }
    
}
