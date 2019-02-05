/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaces;

import modelo.NodeA;

/**
 *
 * @author italo
 */
public interface InterfaceNodeProximoAnterior extends InterfaceNodeGenerica {

    /**
     * Este método cria um objeto do tipo NodeA
     * 
     * @param message menssagem do node criado
     * @param id id do node criado
     * @return retorna o node criado
     */
    NodeA createNode(String message, int id);
    
    /**
     * Getter do primeiro node da lista
     * 
     * @return retorna o primeiro node da lista
     */
    NodeA getFirstNode();

    /**
     * Getter do último node da lista
     * 
     * @return retorna o último node encontrado
     */
    NodeA getLastNode();

    /**
     * Este método pesquisa um node por sua posição
     * 
     * @param index posição no qual o node se encontra
     * @return retorna o nome referente a posição passada no argumento deste
     * método
     */
    NodeA getNodeByIndex(int index);

    /**
     * Este método pesquisa um noe pela mensagem
     * 
     * @param message mensagem utilizada para a busca
     * @return retorna o node que contém a mensagem do argumento deste método
     */
    NodeA searchByMessage(String message);

    /**
     * Este médodo pesquisa um node pelo ID
     * 
     * @param id id utilizado para busca
     * @return retorna o node que contém o id do argumento deste método
     */
    NodeA searchById(int id);

}
