/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Classe que representa os nodes da lista encadeada.
 *
 * @author humberto fioravante
 */
public class Node {

    protected String message;  // Mensagem
    protected int id;    // Identificador da mensagem
    protected Node nextNode = null; // proximo node; inicializado como null por default      

    /**
     * Construtor que cria cada node e inicializa com os atributos message e id
     *
     * @param msgDesc Parametro utilizado como Mensagem do Node que vai ser
     * criado
     * @param msgId Parametro utilizado como Id do Node que vai ser criado
     */
    public Node(String msgDesc, int msgId) {
        this.message = msgDesc;
        this.id = msgId;
    }

    /**
     * Getter do atributo message (mensagem do node).
     *
     * @return String variavel com a mensagem do node
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter do atributo message (mensagem do node).
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Node getNextNode() {
        return nextNode;
    }

    /**
     *
     * @param nextNode
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "\n-> Node atual:"
                        + "\n    Mensagem [" + message + "]"
                        + "\n          Id [" + id + "]"
                        + (nextNode == null
                        ? "\n-> Próximo node é nulo\n"
                        : "\n    Mensagem [" + nextNode.message + "]"
                        + "\n          Id [" + nextNode.id + "]");
        
    
    }

    public String toString1() {
        return " " + id;
    }
}
