/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura.dados;

/**
 * Classe que representa os nodes da lista encadeada.
 *
 * @author humberto fioravante
 */
public class Node {

    String msgDesc;  // Mensagem
    int msgId;    // Identificador da mensagem
    Node nextNode = null; // proximo node; inicializado como null por default      

    /**
     * Construtor que cria cada node e inicializa com os atributos msgDesc e
     * msgId
     *
     * @param msgDesc Parametro utilizado como Mensagem do Node que vai ser
     * criado
     * @param msgId Parametro utilizado como Id do Node que vai ser criado
     */
    public Node(String msgDesc, int msgId) {
        this.msgDesc = msgDesc;
        this.msgId = msgId;
    }

    /**
     * Getter do atributo msgDesc (mensagem do node).
     *
     * @return String variavel com a mensagem do node
     */
    public String getMsgDesc() {
        return msgDesc;
    }

    /**
     * Setter do atributo msgDesc (mensagem do node).
     *
     * @param msgDesc
     */
    public void setMsgDesc(String msgDesc) {
        this.msgDesc = msgDesc;
    }

    /**
     *
     * @return
     */
    public int getMsgId() {
        return msgId;
    }

    /**
     *
     * @param msgId
     */
    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    /**
     *
     * @return
     */
    public Node getProxNode() {
        return nextNode;
    }

    /**
     *
     * @param proxNode
     */
    public void setProxNode(Node proxNode) {
        this.nextNode = proxNode;
    }
}
