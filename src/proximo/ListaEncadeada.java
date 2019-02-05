/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proximo;

import modelo.Node;
import modelo.interfaces.InterfaceNodeProximo;

/**
 * Classe que representa a lista encadeada.
 *
 * @author humberto ferro
 */
public class ListaEncadeada implements InterfaceNodeProximo {

    private Node firstNode = null; //Cabeça da lista; ou seja, primeiro no
    private int size = 0; //quantidade de nos na lista encadeada    

    @Override
    public Node createNode(String message, int id) {
        return new Node(message, id);
    }

    @Override
    public Node getFirstNode() {
        return firstNode;
    }

    @Override
    public Node getLastNode() {
        Node tmpNode = null;
        if (firstNode != null) { //percorre a lista encadeada até achar o último node
            tmpNode = firstNode;
            while (tmpNode.getNextNode() != null) {// sai do loop quando achar o ultimo node (o ultimo node eh o unico cujo proxNode eh null)
                tmpNode = tmpNode.getNextNode();
            }
        }
        return tmpNode;
    }

    @Override
    public Node getNodeByIndex(int index) {
        Node node = firstNode;
        int cont = 1;
        while (cont < index) {
            cont++;
            node = node.getNextNode();
        }
        return node;
    }

    /**
     * Este método retorna o node anterior ao que foi passado como argumento
     * 
     * @param node node base para busca
     * @return node anterior ao do argumento
     */
    public Node getNodeBefore(Node node) {
        Node nodeNext = firstNode;
        while (nodeNext.getNextNode() != null) {
            if (nodeNext.getNextNode() == node) {
                return nodeNext;
            }
            nodeNext = nodeNext.getNextNode();
        }
        return nodeNext;
    }
    
    @Override
    public Node searchByMessage(String message) {
        int i = 1;
        Node node = firstNode;

        do {
            if (node.getMessage().equalsIgnoreCase(message)) {
                return node;
            }
            node = node.getNextNode();
        } while (i < size);

        return node;
    }

    @Override
    public Node searchById(int id) {
        int i = 1;
        Node node = firstNode;

        while (i != 0) {
            node = node.getNextNode();
            if (node.getId() == id) {
                i = 0;
            }
        }
        return node;
    }


    @Override
    public void insertNode(String message, int id) {
        insertNode(message, id, false);
    }

    @Override
    public void insertNode(String message, int id, boolean toSee) {
        Node novoNode = createNode(message, id); //cria um novo node para ser inserido na lista
        size++; //Incrementa o numero de nodes existente na lista        
        if (toSee) {// se for para imprimir mensagens quando da insercao... 
            System.out.printf("Inserindo o %d-ésimo node na lista, com mensagem = %s e id = %d\n", size, message, id);
        }
        if (firstNode == null) {
            firstNode = novoNode;

        } else {
            Node lastNode = getLastNode(); //determina o ultimo node
            lastNode.setNextNode(novoNode);
        }
    }

    @Override
    public void insertNodeFirst(String message, int id) {
        if (firstNode != null) {
            Node nodeNew = createNode(message, id);
            nodeNew.setNextNode(firstNode);
            firstNode = nodeNew;
        }
    }

    @Override
    public void insertNodeFirst(String message, int id, boolean toSee) {
        if (toSee) {// se for para imprimir mensagens quando da insercao... 
            System.out.printf("Inserindo o %d-ésimo node na lista, com mensagem = %s e id = %d\n", 1, message, id);
        }
        insertNodeFirst(message, id);
    }

    @Override
    public void insertNodeByIndex(String message, int id, int index) {
        insertNodeByIndex(message, id, index, false);
    }

    @Override
    public void insertNodeByIndex(String message, int id, int index, boolean toSee) {
        Node nodeCriado = createNode(message, id);
        if (toSee) {// se for para imprimir mensagens quando da insercao... 
            System.out.printf("Inserindo o %d-ésimo node na lista, com mensagem = %s e id = %d\n", index, message, id);
        }
        if (index == 1) {
            Node node = firstNode;
            nodeCriado.setNextNode(node);
            firstNode = nodeCriado;

        } else if (index == (size + 1)) {
            insertNode(message, id);

        } else {
            Node nodeParaSubstituir = getNodeByIndex(index - 1);
            nodeCriado.setNextNode(nodeParaSubstituir.getNextNode()); //se pegar o próximo ele fica com função de remover o da posição
            nodeParaSubstituir.setNextNode(nodeCriado);
        }
        size++;
    }

    @Override
    public void deleteFirstNode() {
        if (firstNode != null) {
            if (firstNode.getNextNode() == null) {
                firstNode = null;
            } else {
                firstNode = firstNode.getNextNode();
            }
            size--;
        }
    }

    @Override
    public void deleteLastNode() {
        if (size > 0) {
            if (firstNode.getNextNode() == null) {
                firstNode = null;
            
            } else {
                Node node = getNodeByIndex(size - 1);
                node.setNextNode(null);
            }
            size--;
        }
    }

    @Override
    public void deleteByIndex(int index) {
        if (index == 1) {
            deleteFirstNode();
            
        } else if (index == size) {
            deleteLastNode();
            
        } else if (size > 1) {
            Node nodeAtual = firstNode;
            Node nodeUltimo = null;
            int i = 1;
            while (i != index) {
                i++;
                nodeUltimo = nodeAtual;
                nodeAtual = nodeAtual.getNextNode();
            }
            
            if ( nodeAtual == null ) {
                nodeUltimo.setNextNode(null);
                
            } else {
                nodeUltimo.setNextNode(nodeAtual.getNextNode());
            }
            size--;
        }
    }

    @Override
    public void swapAdjacent(int index) {
        Node nodeBeforeIndex;
        Node nodeIndex;
        Node nodeNext;
        
        if (index == 1) {
            nodeIndex = firstNode;
            nodeNext = nodeIndex.getNextNode();
            Node nodeProximoProximo = nodeNext.getNextNode();

            firstNode = nodeNext;
            nodeNext.setNextNode(nodeIndex);
            nodeIndex.setNextNode(nodeProximoProximo);
            return;

        } else if (index == size) {
            index -= 2;

        } else if (index > 0 && index <= size) {
            index--;

        }

        if (index != -1) {
            nodeBeforeIndex = getNodeByIndex(index);
            nodeIndex = nodeBeforeIndex.getNextNode();
            nodeNext = nodeIndex.getNextNode();
            
        } else {
            nodeBeforeIndex = getNodeBefore(firstNode);
            nodeIndex = nodeBeforeIndex.getNextNode();
            nodeNext = nodeIndex.getNextNode();
            
        }

        nodeBeforeIndex.setNextNode(nodeNext);
        nodeIndex.setNextNode(nodeNext.getNextNode());
        nodeBeforeIndex.getNextNode().setNextNode(nodeIndex);
    }

    @Override
    public void swapArbitrary(int index, int indez) {
        if (index == indez) {
            return;
        }
        if (index + 1 == indez || index - 1 == indez) {
            if (index < indez) {
                swapAdjacent(index);
            } else {
                swapAdjacent(indez);
            }

            return;
        } else if (index == 1 || indez == 1) {
            if (indez == 1) {
                indez = index;
            }
            indez--;
            Node nodeIndexFirst = firstNode;
            Node nodeIndexSecond = nodeIndexFirst.getNextNode();

            Node nodeIndezAnterior = getNodeByIndex(indez);
            Node nodeIndez = nodeIndezAnterior.getNextNode();
            Node nodeIndezProximo = nodeIndez.getNextNode();

            firstNode = nodeIndez;
            nodeIndez.setNextNode(nodeIndexSecond);
            nodeIndezAnterior.setNextNode(nodeIndexFirst);
            nodeIndexFirst.setNextNode(nodeIndezProximo);
            return;
        }

        Node nodeIndexAnterior = getNodeByIndex(index - 1);
        Node nodeIndex = nodeIndexAnterior.getNextNode();
        Node nodeIndexProximo = nodeIndex.getNextNode();

        Node nodeIndezAnterior = getNodeByIndex(indez - 1);
        Node nodeIndez = nodeIndezAnterior.getNextNode();
        Node nodeIndezProximo = nodeIndez.getNextNode();

        nodeIndezAnterior.setNextNode(nodeIndex);
        nodeIndexAnterior.setNextNode(nodeIndez);
        nodeIndez.setNextNode(nodeIndexProximo);
        nodeIndex.setNextNode(nodeIndezProximo);
    }

    @Override
    public void show() {
        int contaNode = 1;
        Node tmpNode = firstNode; //variavel temporaria, aponta para o primeiro node
        System.out.println("========================================================================");
        while (tmpNode != null) {// sai do loop quando achar o ultimo node (o ultimo node eh o unico cujo proxNode eh null)
            System.out.println("Node = " + contaNode++ + tmpNode.toString());
            tmpNode = tmpNode.getNextNode();
        }
        System.out.printf("null (Fim da lista)");
        System.out.printf("\n========================================================================\n");
    }

    /**
     * Este método exibe somente os ID's da seginte maneira: " id id ...".
     */
    public void show1() {
        Node tmpNode = firstNode; //variavel temporaria, aponta para o primeiro node
        
        while ( tmpNode != null ) {// sai do loop quando achar o ultimo node (o ultimo node eh o unico cujo proxNode eh null)
            System.out.print(tmpNode.toString1());
            tmpNode = tmpNode.getNextNode();
        }
        System.out.println("");
    }
    
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 
     * @param nodeIndex
     * @return 
     */
    public int getIndexByNode(Node nodeIndex) {
        Node node = firstNode;
        int cont = 1;
        
        while (node.getNextNode() != null) {
            if (node == nodeIndex) {
                return cont;
            }
            cont++;
            node = node.getNextNode();
        }
        return cont;
    }
    
    @Override
    public void bubbleSort() {
        if ( size > 1 ) {
            Node nodeVerify = firstNode;
            int cont = 0;
            
            while ( cont < size - 1) {
                if ( nodeVerify.getId() > nodeVerify.getNextNode().getId() ) {
                    swapAdjacent(getIndexByNode(nodeVerify));
                    
                } else {
                    nodeVerify = nodeVerify.getNextNode();
                }
                cont++;
            }
        }       
    }
    
    @Override
    public void bubbleSort1() {
        int cont = 1;
        System.out.print("    Ordenar: ");
        show1();
        while ( cont <= size -1 ) {
            bubbleSort();
            System.out.print(cont + "ª iteração: ");
            show1();
            cont++;
        }
    }

}
