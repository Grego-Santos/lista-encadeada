/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura.dados;

/**
 * Classe que representa a lista encadeada.
 *
 * @author humberto ferro
 */
public class ListaEncadeada {

    private Node firstNode = null; //Cabeça da lista; ou seja, primeiro no
    private int qtdNodes = 0; //quantidade de nos na lista encadeada

    /**
     * Getter do atributo firstNode
     *
     * @return
     */
    public Node getFirstNode() {
        return firstNode;
    }

    /**
     *
     * @return
     */
    public int getQtdNodes() {
        return qtdNodes;
    }

    private Node criaNode(String msgDesc, int msgId) {//Cria um novo node
        /**
         * Esse metodo é usado para criar um novo node.
         *
         * @param msgDesc Parametro utilizado como Mensagem do Node que vai ser
         * criado e inserido
         * @param msgId Parametro utilizado como Id do Node que vai ser criado e
         * inserido
         * @return Node Variavel que aponta para o ultimo node da lista
         */
        Node novoNode = new Node(msgDesc, msgId); //cria novo node
        return novoNode; //retorna o node criado
    }

    /**
     *
     * Esse metodo é usado para percorrer a lista e imprimir o seu conteúdo.
     */
    public void imprimeLista() {
        int contaNode = 1;
        Node tmpNode = firstNode; //variavel temporaria, aponta para o primeiro node
        System.out.println("========================================================================");
        while (tmpNode != null) {// sai do loop quando achar o ultimo node (o ultimo node eh o unico cujo proxNode eh null)
            System.out.printf("Node=%d (Msg \"%s\" com Id %d) \n", contaNode++, tmpNode.getMsgDesc(), tmpNode.getMsgId());
            tmpNode = tmpNode.getProxNode();
        }
        System.out.printf("null (Fim da lista)");
        System.out.printf("\n========================================================================\n");
    }// end imprimeLista()

    private Node achaUltimoNode() {
        /**
         * Esse metodo é usado para localizar o ultimo node da lista; se a lista
         * estiver vazia, retorna null. Nesse escopo, percorre a lista node a
         * node até o fim.
         *
         * @return Node Variavel que aponta para o ultimo node da lista
         */
        Node tmpNode = null;
        if (firstNode != null) { //percorre a lista encadeada até achar o último node
            tmpNode = firstNode;
            while (tmpNode.getProxNode() != null) {// sai do loop quando achar o ultimo node (o ultimo node eh o unico cujo proxNode eh null)
                tmpNode = tmpNode.getProxNode();
            }
        }
        return tmpNode;
    }

    /**
     * Esse metodo é uma versão sobrecarregada do método insereNode(String
     * msgDesc, int msgId, boolean verbose), com o parâmetro verbose configurado
     * como falso.
     *
     * @param msgDesc Parametro utilizado como Mensagem do Node que vai ser
     * criado e inserido
     * @param msgId Parametro utilizado como Id do Node que vai ser criado e
     * inserido
     */
    public void insereNode(String msgDesc, int msgId) {
        insereNode(msgDesc, msgId, false);
    }

    /**
     * Esse metodo é usado para inserir um novo node na lista encadeada. Faz uso
     * de dois metodos privados, achaUltimoNode(), para localizar o ultimo node
     * da lista, e criaNode(), para criar o node que vai ser inserido.
     *
     * @param msgDesc Parametro utilizado como Mensagem do Node que vai ser
     * criado e inserido
     * @param msgId Parametro utilizado como Id do Node que vai ser criado e
     * inserido
     * @param verbose Modo verboso, imprime informacoes do node que esta sendo
     * inserido
     */
    public void insereNode(String msgDesc, int msgId, boolean verbose) {
        Node novoNode = criaNode(msgDesc, msgId); //cria um novo node para ser inserido na lista
        qtdNodes++; //Incrementa o numero de nodes existente na lista        
        if (verbose) {// se for para imprimir mensagens quando da insercao... 
            System.out.printf("Inserindo o %d-ésimo node na lista, com mensagem = %s e id = %d\n", qtdNodes, msgDesc, msgId);
        }
        if (firstNode == null) {
            firstNode = novoNode;
        } else {
            Node lastNode = achaUltimoNode(); //determina o ultimo node
            lastNode.setProxNode(novoNode);
        }
    }

    public Node getNodeByIndex(int index) {
        Node node = firstNode;
        int cont = 1;
        while (cont < index) {
            cont++;
            node = node.getProxNode();
        }
        return node;
    }

    public void swapAdjacente(int index) {
        if (index == 1) {
            Node nodeIndex = firstNode;
            Node nodeProximo = nodeIndex.getProxNode();
            Node nodeProximoProximo = nodeProximo.getProxNode();

            firstNode = nodeProximo;
            nodeProximo.setProxNode(nodeIndex);
            nodeIndex.setProxNode(nodeProximoProximo);
            return;
        } else if (index == qtdNodes) {
            index -= 2;
            
        } else if (index > 0 && index <= qtdNodes) {
            index--;
            
        }
        
        Node nodeAnteriorIndex = getNodeByIndex(index);
        Node nodeIndex = nodeAnteriorIndex.getProxNode();
        Node nodeProximo = nodeIndex.getProxNode();

        nodeAnteriorIndex.setProxNode(nodeProximo);
        nodeIndex.setProxNode(nodeProximo.getProxNode());
        nodeAnteriorIndex.getProxNode().setProxNode(nodeIndex);
    }
    
    public void swapArbitrario(int index, int indez) {
        if (index + 1 == indez || index - 1 == indez) {
            swapAdjacente(index);
        }
    }

}// end class

