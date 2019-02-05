/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import modelo.Node;

/**
 *
 * @author italo
 */
public interface InterfaceNodeProximo extends InterfaceNodeGenerica {

    /**
     * Esse metodo é usado para criar um novo node.
     *
     * @param message Parâmetro utilizado como Mensagem do Node que vai ser
     * criado e inserido
     * @param id Parametro utilizado como Id do Node que vai ser criado e
     * inserido
     * @return Node Variavel que aponta para o ultimo node da lista
     */
    Node createNode(String message, int id);
    
    /**
     * Getter do atributo firstNode
     *
     * @return
     */
    Node getFirstNode();

    /**
     * Getter do último node
     * @return 
     */
    Node getLastNode();

    /**
     * Este método retorna o node contido na posição passada como argumento do
     * método
     *
     * @param index posição em que o node se encontra
     * @return node encontrado
     */
    Node getNodeByIndex(int index);

    /**
     * Este método pesquisa um node através de sua mensagem, retornando o node
     * encontrado
     *
     * @param message
     * @return
     */
    Node searchByMessage(String message);

    /**
     * Este método pesquisa um node através de seu ID, retornando o node
     * encontrado
     *
     * @param id valor do ID que será buscado
     * @return node encontrado
     */
    Node searchById(int id);
    
}
