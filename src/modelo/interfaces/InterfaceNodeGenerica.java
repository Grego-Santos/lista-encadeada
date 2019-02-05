/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

/**
 *
 * @author italo
 */
public interface InterfaceNodeGenerica {

    /**
     * Esse metodo é uma versão sobrecarregada do método insereNode(String
     * message, int id, boolean toSee), com o parâmetro toSee configurado como
     * falso.
     *
     * @param message Parametro utilizado como Mensagem do Node que vai ser
     * criado e inserido
     * @param id Parametro utilizado como Id do Node que vai ser criado e
     * inserido
     */
    void insertNode(String message, int id);

    /**
     * Esse metodo é usado para inserir um novo node na lista encadeada; Faz uso
     * de dois metodos privados, achaUltimoNode(), para localizar o ultimo node
     * da lista, e criaNode(), para criar o node que vai ser inserido
     *
     * @param message Parametro utilizado como Mensagem do Node que vai ser
     * criado e inserido
     * @param id Parametro utilizado como Id do Node que vai ser criado e
     * inserido
     * @param toSee Modo verboso, imprime informacoes do node que esta sendo
     * inserido
     */
    void insertNode(String message, int id, boolean toSee);
    
    /**
     * Este método chama internamente o método insertNodeFirst passando como
     * false o parâmetro toSee
     * 
     * @param message
     * @param id 
     */
    void insertNodeFirst(String message, int id);
    
    /**
     * Este método insere um node na primeira posição, podendo o usuário
     * ver sua inserção
     * @param message mensagem do node
     * @param id id do node
     * @param toSee opção para visualizar o node
     */
    void insertNodeFirst(String message, int id, boolean toSee);
    
    /**
     * Este método chama internamente o método insertNodeByIndex, passando o
     * parâmetro "toSee" como sendo false
     * 
     * @param message mensagem do node
     * @param id id do node
     * @param index posição na qual será feita a inserção
     */
    void insertNodeByIndex(String message, int id, int index);
    
    /**
     * Este método insere um novo nome em uma posição determinada pelo usuário,
     * podendo mostrar o nome inserido
     * 
     * @param message mensagem do node
     * @param id id do node
     * @param index posição na qual será feita a inserção
     * @param toSee visualizar o node inserido
     */
    void insertNodeByIndex(String message, int id, int index, boolean toSee);

    /**
     * Deleta o primeiro node da cadeia.
     */
    void deleteFirstNode();

    /**
     * Deleta o último node da cadeia.
     */
    void deleteLastNode();

    /**
     * Deleta o node na posição indicada pelo argumento do método
     *
     * @param index posicao em que deve deletar o node
     */
    void deleteByIndex(int index);

    /**
     * Este método faz uma troca entre nodes adjacentes/de lado; caso a posição
     * pasada seja o último node, ele fará a troca do penúltimo com o último
     *
     * @param index posição em que está o node
     */
    void swapAdjacent(int index);

    /**
     * Este método faz a troca de posição entre dois nodes, no qual suas
     * posições são passadas como argumentos
     *
     * @param index node X a ser colocado na posição Z
     * @param indez node Z a ser colocado na posição X
     */
    void swapArbitrary(int index, int indez);

    /**
     * Esse metodo é usado para percorrer a lista e imprimir o seu conteúdo.
     */
    void show();

    /**
     * Getter do size da lista
     *
     * @return tamanho da lista
     */
    int getSize();
    
    /**
     * Algoritmo da bolha; este método verifica se o ID atual é maior que o seu
     * próximo, caso seja, ele chama o método swapAdjacent e faz a troca dos
     * nodes pegando o index com o método getIndexByNode; caso não seja, ele
     * pega um próximo node para fazer essa verificação, vide exemplo:
     * 
     *  Organizar: 3 5 4 6 0
     * 1ª passada: 3 4 5 0 6
     * 
     * Para que a lista seja totalmente ordenada, é necessário repetir o
     * processedimento até que não haja mais troca.
     */
    public void bubbleSort();
    
    /**
     * Este método faz uso do método bubbleSort para ordenar todos os ID's em
     * ordem crescente.
     */
    public void bubbleSort1();
}
