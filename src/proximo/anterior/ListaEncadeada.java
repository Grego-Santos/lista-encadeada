/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proximo.anterior;

import modelo.NodeA;
import modelo.interfaces.InterfaceNodeProximoAnterior;

/**
 *
 * @author italo
 */
public class ListaEncadeada implements InterfaceNodeProximoAnterior {

    private int size = 0;
    private NodeA firstNode;

    @Override
    public NodeA createNode(String message, int id) {
        return new NodeA(message, id);
    }

    @Override
    public NodeA getFirstNode() {
        return firstNode;
    }

    @Override
    public NodeA getLastNode() {
        NodeA tmpNode = null;

        if (firstNode != null) { //percorre a lista encadeada até achar o último node
            tmpNode = firstNode;
            while (tmpNode.getNextNode() != null) {// sai do loop quando achar o ultimo node (o ultimo node eh o unico cujo proxNode eh null)
                tmpNode = tmpNode.getNextNode();
            }
        }

        return tmpNode;
    }

    @Override
    public NodeA getNodeByIndex(int index) {
        NodeA node = firstNode;
        if (index > size) {
            return null;
        }
        if (node != null) {
            int cont = 1;
            while (cont != index) {
                node = node.getNextNode();
                cont++;
            }
        }
        return node;
    }

    /**
     * Este método retorna o Index do node passado como argumento do método
     *
     * @param nodeIndex node a ser verificado
     * @return index do node
     */
    public int getIndexByNode(NodeA nodeIndex) {
        NodeA node = firstNode;
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
    public NodeA searchByMessage(String message) {
        NodeA node = firstNode;

        while (!node.getMessage().equalsIgnoreCase(message)) {
            node = node.getNextNode();
        }
        return node;
    }

    @Override
    public NodeA searchById(int id) {
        NodeA node = firstNode;

        while (node.getId() != (id)) {
            node = node.getNextNode();
        }
        return node;
    }

    /**
     * Este método retorna o respectivo node da posição passada no argumento do
     * método
     *
     * @param index posição do node pesquisado
     * @return node encontrado
     */
    public NodeA searchByIndex(int index) {
        return getNodeByIndex(index);
    }

    @Override
    public void insertNode(String message, int id) {
        insertNode(message, id, false);
    }

    @Override
    public void insertNode(String message, int id, boolean toSee) {
        size++;
        NodeA node = createNode(message, id);
        if (toSee) {// se for para imprimir mensagens quando da insercao... 
            System.out.printf("Inserindo o %d-ésimo node na lista, com mensagem = %s e id = %d\n", size, message, id);

        }

        if (firstNode == null) {
            firstNode = node;

        } else {
            NodeA nodeLast = getLastNode();
            nodeLast.setNextNode(node);
            node.setBeforeNode(nodeLast);
        }
    }

    @Override
    public void insertNodeFirst(String message, int id) {
        insertNodeFirst(message, id, false);
    }

    @Override
    public void insertNodeFirst(String message, int id, boolean toSee) {
        if (toSee) {// se for para imprimir mensagens quando da insercao... 
            System.out.printf("Inserindo o %d-ésimo node na lista, com mensagem = %s e id = %d\n", size, message, id);
        }

        NodeA nodeNew = createNode(message, id);

        if (firstNode == null) {
            firstNode = nodeNew;

        } else {
            NodeA nodeFirst = firstNode;
            nodeFirst.setBeforeNode(nodeNew);
            nodeNew.setNextNode(nodeFirst);
            firstNode = nodeNew;
        }
        size++;
    }

    @Override
    public void insertNodeByIndex(String message, int id, int index) {
        insertNodeByIndex(message, id, index, false);

    }

    @Override
    public void insertNodeByIndex(String message, int id, int index, boolean toSee) {
        NodeA node = createNode(message, id);
        size++;

        if (toSee) {// se for para imprimir mensagens quando da insercao... 
            System.out.printf("Inserindo o %d-ésimo node na lista, com mensagem = %s e id = %d\n", size, node.getMessage(), node.getId());
        }

        if (firstNode == null) {
            firstNode = node;

        } else if (index == size + 1) {
            insertNode(message, id);

        } else {
            NodeA nodeIndex = getNodeByIndex(index);
            node.setNextNode(nodeIndex);
            node.setBeforeNode(nodeIndex.getBeforeNode());
            node.getBeforeNode().setNextNode(node);
            node.getNextNode().setBeforeNode(node);
        }
    }

    @Override
    public void deleteFirstNode() {
        
    }
    
    public NodeA deleteFirstNodeA() {
        if (firstNode != null) {
            NodeA b = firstNode;
            firstNode = firstNode.getNextNode();
            if (firstNode != null) {
                firstNode.setBeforeNode(null);
            }
            size = size == 0 ? size : size - 1;
            return b;
        }
        return null;
    }
    
    @Override
    public void deleteLastNode() {
        
    }
    
    public NodeA deleteLastNodeA() {
        if (firstNode != null) {
            NodeA nodeLast = getLastNode();
            if (nodeLast.getBeforeNode() == null && nodeLast.getNextNode() == null) {
                firstNode = null;

            } else {
                nodeLast.getBeforeNode().setNextNode(null);
            }
            size = size == 0 ? size : size - 1;
            return nodeLast;
        }
        return null;
    }

    @Override
    public void deleteByIndex(int index) {
        
    }
    
    public NodeA deleteByIndexA(int index) {
        if (firstNode != null) {
            if (index == 1) {
                return deleteFirstNodeA();

            } else if (index == size) {
                deleteLastNode();

            } else {
                NodeA nodeAtual = getNodeByIndex(index);
                if (nodeAtual == null) {
                    return null;
                }
                nodeAtual.getBeforeNode().setNextNode(nodeAtual.getNextNode());
                if (nodeAtual.getNextNode() != null) {
                    nodeAtual.getNextNode().setBeforeNode(nodeAtual.getBeforeNode());
                }
                size = size == 0 ? size : size - 1;
                return nodeAtual;
            }

        }
        return null;
    }

    @Override
    public void swapAdjacent(int index) {
        if (size > 1) {
            NodeA nodeIndex;

            if (index == 1) {
                nodeIndex = firstNode;
                firstNode = firstNode.getNextNode();

                if (firstNode.getNextNode() != null) {
                    firstNode.getNextNode().setBeforeNode(nodeIndex);
                }

                nodeIndex.setNextNode(firstNode.getNextNode());
                nodeIndex.setBeforeNode(firstNode);
                firstNode.setNextNode(nodeIndex);
                firstNode.setBeforeNode(null);

            } else if (index < size) {
                nodeIndex = getNodeByIndex(index);
                NodeA nodeBefore = nodeIndex.getNextNode();

                nodeBefore.setBeforeNode(nodeIndex.getBeforeNode());
                nodeIndex.setNextNode(nodeBefore.getNextNode());
                nodeBefore.getBeforeNode().setNextNode(nodeBefore);
                nodeBefore.setNextNode(nodeIndex);
                nodeIndex.setBeforeNode(nodeBefore);

                if (index + 1 != size) {
                    nodeIndex.getNextNode().setBeforeNode(nodeIndex);
                }
            }
        }
    }

    @Override
    public void swapArbitrary(int index, int indez) {
        if (index + 1 == indez) {
            swapAdjacent(index);
            return;
        }

        if (indez + 1 == index) {
            swapAdjacent(indez);
            return;
        }

        if (index == indez) {
            return;
        }

        if (index > indez) {
            int a = index;
            index = indez;
            indez = a;
        }

        if (index > size || indez > size) {
            return;
        }

        NodeA nodeIndex = getNodeByIndex(index);
        NodeA nodeIndez = getNodeByIndex(indez);

        NodeA nodeIndexNext = nodeIndex.getNextNode();
        NodeA nodeIndexBefore = nodeIndex.getBeforeNode();

        if (indez != size) {
            nodeIndez.getNextNode().setBeforeNode(nodeIndex);
        }

        nodeIndez.getBeforeNode().setNextNode(nodeIndex);
        nodeIndex.setBeforeNode(nodeIndez.getBeforeNode());
        nodeIndex.setNextNode(nodeIndez.getNextNode());

        if (index != 1) {
            nodeIndexBefore.setNextNode(nodeIndez);

        } else {
            firstNode = nodeIndez;
        }

        nodeIndexNext.setBeforeNode(nodeIndez);
        nodeIndez.setBeforeNode(nodeIndexBefore);
        nodeIndez.setNextNode(nodeIndexNext);
    }

    @Override
    public void show() {
        NodeA tmpNode = firstNode; //variavel temporaria, aponta para o primeiro node

        System.out.println("========================================================================");
        while (tmpNode != null) {// sai do loop quando achar o ultimo node (o ultimo node eh o unico cujo proxNode eh null)
            System.out.println(tmpNode.toString());
            tmpNode = tmpNode.getNextNode();
        }
        System.out.printf("null (Fim da lista)");
        System.out.printf("\n========================================================================\n");
    }

    /**
     * Este método exibe somente os ID's da seginte maneira: " id id ...".
     */
    public void show1() {
        NodeA tmpNode = firstNode; //variavel temporaria, aponta para o primeiro node

        while (tmpNode != null) {// sai do loop quando achar o ultimo node (o ultimo node eh o unico cujo proxNode eh null)
            System.out.print(tmpNode.toString1());
            tmpNode = tmpNode.getNextNode();
        }

        System.out.println("");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void bubbleSort() {
        if (size > 1) {
            NodeA nodeVerify = firstNode;
            int cont = 0;
            while (cont < size - 1) {
                if (nodeVerify.getId() > nodeVerify.getNextNode().getId()) {
                    swapAdjacent(getIndexByNode(nodeVerify));

                } else {
                    nodeVerify = nodeVerify.getNextNode();
                }
                cont++;
            }
        }
    }

    public boolean bubbleSort3() {
        boolean iterar = true;
        if (size > 1) {
            NodeA nodeVerify = firstNode;
            int cont = 0;

            while (cont < size - 1) {
                if (nodeVerify.getId() > nodeVerify.getNextNode().getId()) {
                    swapAdjacent(getIndexByNode(nodeVerify));

                } else {
                    nodeVerify = nodeVerify.getNextNode();
                }
                cont++;
            }
        }
        return iterar;
    }

    @Override
    public void bubbleSort1() {
        int cont = 0;
        System.out.print("Buble sort:");
        while (cont < size - 1) {
            cont++;
            bubbleSort();
        }
        System.out.println("");
    }
    
    public void selectSort(boolean stepByStep) {
        if (size > 1) {
            NodeA index = firstNode;
            NodeA menor = firstNode;
            NodeA proximo = firstNode;
            
            while (index.getNextNode() != null) {
                if (proximo == null) {
                    swapArbitrary(getIndexByNode(index), getIndexByNode(menor));
                    proximo = index = menor = menor.getNextNode();
                    if (stepByStep) {
                        show1();
                    }
                } else if (menor.getId() > proximo.getId()) {
                    menor = proximo;
                }
                proximo = proximo.getNextNode();
            }
        }
    }
    
    public void insertionSort() {
        if (size > 1) {
            NodeA index = firstNode.getNextNode();
            NodeA troca = firstNode;
            
            while ( index != null ) {
                while (index.getId() < troca.getId()) {
                    
                }
                index = index.getNextNode();
            }            
        }
    }

    /*
     * SHOWS
     */
    public void showDeleteFirst() {
        System.out.println("Size antes da deleção first: " + size + " nodes");
        System.out.println("Lista antes da deleção first:");
        show1();
        System.out.println("Lista após deleção first:");
        deleteFirstNode();
        show1();
        System.out.println(" Size = " + size);
        System.out.println("");
    }

    public void showDeleteLast() {
        System.out.println("Size antes da deleção last: " + size + " nodes");
        System.out.println("Lista antes da deleção last:");
        show1();
        System.out.println("Lista após deleção last:");
        deleteLastNode();
        show1();
        System.out.println(" Size = " + size);
        System.out.println("");
    }

    public void showDeleteByIndex(int index) {
        System.out.println("Size antes da deleção por index: " + size + " nodes");
        System.out.println("Lista antes da deleção por index:");
        show1();
        System.out.println("Lista após deleção por index:");
        deleteByIndex(index);
        show1();
        System.out.println(" Size = " + size);
        System.out.println("");
    }

    public void showInsertFirstNode(String msg, int id) {
        System.out.println("Size antes da primeira inserção: " + size + " nodes");
        System.out.println("Lista antes da primeira inserção:");
        show1();
        System.out.println("Inserção: \n"
                + "         Mensagem [" + msg + "]\n"
                + "               Id [" + id + "]\n");
        insertNodeFirst(msg, id);
        System.out.println("Lista após a primeira inserção:");
        show1();
        System.out.println(" Size = " + size);
        System.out.println("");
    }

    public void showInsertLastNode(String msg, int id) {
        System.out.println("Size antes da última inserção: " + size + " nodes");
        System.out.println("Lista antes da última inserção:");
        show1();
        System.out.println("Inserção: \n"
                + "         Mensagem [" + msg + "]\n"
                + "               Id [" + id + "]\n");
        insertNode(msg, id);
        System.out.println("Lista após última inserção:");
        show1();
        System.out.println(" Size = " + size);
        System.out.println("");
    }

    public void showInsertByIndex(String msg, int id, int index) {
        System.out.println("Size antes da inserção por index: " + size + " nodes");
        System.out.println("Lista antes da inserção por index:");
        show1();
        System.out.println("Inserção por index: \n"
                + "          Posição [" + index + "]\n"
                + "         Mensagem [" + msg + "]\n"
                + "               Id [" + id + "]\n");
        insertNodeByIndex(msg, id, index);
        System.out.println("Lista após inserção por index:");
        show1();
        System.out.println(" Size = " + size);
        System.out.println("");
    }

    public void showSwapAdjacent(int index) {
        System.out.println("Size antes do swap adjacent: " + size + " nodes");
        System.out.println("Lista antes do swap adjacent:");
        show1();
        System.out.println("Swap adjacent: \n"
                + "          Posição [" + index + "]");
        swapAdjacent(index);
        System.out.println("Lista após swap adjacent:");
        show1();
        System.out.println(" Size = " + size);
        System.out.println("");
    }

    public void showSwapArbitrary(int index, int indez) {
        //System.out.println("Size antes do swap arbitrário: " + size + " nodes");
        System.out.println("Lista antes do swap arbitrário:");
        show1();
        System.out.println("Swap arbitrário: \n"
                + "         PosiçãoX [" + index + "]\n"
                + "         PosiçãoZ [" + indez + "]");
        swapArbitrary(index, indez);
        System.out.println("Lista após swap arbitrário:");
        show1();
        //System.out.println(" Size = " + size);
        System.out.println("");
    }
    
    public void showSelectSort() {
        System.out.println("-- Select Sort --");
        System.out.println("Lista antes da ordenação:");
        show1();
        System.out.println("Lista após ordenação:");
        selectSort(false);
        show1();
        System.out.println("");
    }
    
    public void showSelectSort1() {
        System.out.println("-- Select Sort --");
        System.out.println("Lista antes da ordenação:");
        show1();
        System.out.println("Lista após ordenação:");
        System.out.println("Passos:");
        selectSort(true);
        System.out.println("Ordenado:");
        show1();
    }
    
    public void showInsertionSort() {
        System.out.println("-- Insert Sort --");
        System.out.println("Lista antes da ordenação:");
        show1();
        System.out.println("Lista após ordenação:");
        insertionSort();
        show1();
    }

    public void showListDirect() {
        System.out.println("Lista direta:");
        show1();
        System.out.println("");
    }
    
    public void showListReverse() {
        NodeA tmpNode = getLastNode();
        System.out.println("Lista reversa:");
        while (tmpNode != null) {// sai do loop quando achar o ultimo node (o ultimo node eh o unico cujo proxNode eh null)
            System.out.print(tmpNode.toString1());
            tmpNode = tmpNode.getBeforeNode();
        }
        System.out.println("\n");
    }
}
