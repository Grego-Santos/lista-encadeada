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
public class NodeA {

    private String message;  // Mensagem
    private int id;    // Identificador da mensagem
    private NodeA nextNode = null; // proximo node; inicializado como null por default
    private NodeA beforeNode = null; // node anterior; inicializado como null por default

    public NodeA(String msgDesc, int msgId) {
        this.message = msgDesc;
        this.id = msgId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodeA getNextNode() {
        return nextNode;
    }

    public void setNextNode(NodeA nextNode) {
        this.nextNode = nextNode;
    }

    public NodeA getBeforeNode() {
        return beforeNode;
    }

    public void setBeforeNode(NodeA beforeNode) {
        this.beforeNode = beforeNode;
    }

    @Override
    public String toString() {
        return (beforeNode == null
                        ? "-> Node anterior é nulo\n"
                        : ("-> Node anterior:"
                        + "\n          Id [" + beforeNode.getId() + "]\n"))
                        + "-> Node atual:"
                        + "\n          Id [" + id + "]\n"
                        + (nextNode == null
                        ? "-> Próximo node é nulo\n"
                        : ("-> Node próximo:"
                        + "\n          Id [" + nextNode.getId() + "]\n"));
    }
    
    public String toString1() {
        return " " + id;
    }
}
