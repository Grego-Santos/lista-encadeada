/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura.dados;

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

        lista.insereNode("Primeiro", 1, false);
        lista.insereNode("Segundo", 2, false);
        lista.insereNode("Terceiro", 3, false);

        //System.out.printf("A lista tem %d elementos. Eis a lista:\n\n", lista.getQtdNodes());
        //lista.imprimeLista();

        lista.insereNode("Quarto", 4);
        lista.insereNode("Quinto", 5, false);
        lista.insereNode("Sexto", 6);

        System.out.printf("A lista tem %d elementos. Eis a lista:\n", lista.getQtdNodes());
        lista.imprimeLista();
        
        
        //lista.swapAdjacente(6);
        //lista.imprimeLista();
        
        lista.swapArbitrario(2, 1);
        lista.imprimeLista();
    }

}
