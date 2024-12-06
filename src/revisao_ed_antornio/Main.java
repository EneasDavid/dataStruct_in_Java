package revisao_ed_antornio;

import java.util.Arrays;

import revisao_ed_antonio.a_list.CircularList;
import revisao_ed_antonio.a_list.DoublyLinkedList;
import revisao_ed_antonio.a_list.LinkedList;
import revisao_ed_antonio.b_Stack.Stack;
import revisao_ed_antonio.c_queue.Queue;
import revisao_ed_antonio.d_tree.BinaryTree;
import revisao_ed_antonio.d_tree.Node;
import revisao_ed_antonio.c_queue.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Array para inserir elementos em todas as estruturas
        int[] elements = {10, 20, 30, 40, 50, 60};

        // Testando a Pilha
        System.out.println("Pilha:");
        Stack stack = new Stack(6); // Capacidade 6
        for (int element : elements) {
            stack.push(element);
        }
        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }

        // Testando a Fila
        System.out.println("\nFila:");
        Queue queue = new Queue(6); // Capacidade 6
        for (int element : elements) {
            queue.enqueue(element);
        }
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }

        // Testando a Lista Simples
        System.out.println("\nLista Simples:");
        LinkedList<Integer> list = new LinkedList<>();
        for (int element : elements) {
            list.add(element);
        }
        // Exibindo todos os elementos da lista
        for (int i = 0; i < elements.length; i++) {
            System.out.println("Elemento na posição " + i + ": " + list.get(i));
        }

        // Testando a Lista Simplesmente Encadeada
        System.out.println("\nLista Simplesmente Encadeada:");

        // Converter int[] para Integer[]
        Integer[] elementsPrimitive = Arrays.stream(elements).boxed().toArray(Integer[]::new);

        // Criando uma lista com elementos iniciais
        LinkedList<Integer> linkedList = new LinkedList<>(elementsPrimitive);

        // Exibindo a lista inicial
        System.out.println("Lista Inicial: " + linkedList);

        // Adicionando um elemento no início
        linkedList.add(0, 5);  // Adiciona 5 no início da lista
        System.out.println("Após adicionar 5 no início: " + linkedList);

        // Adicionando um elemento no final
        linkedList.add(60);  // Adiciona 60 no final da lista
        System.out.println("Após adicionar 60 no final: " + linkedList);

        // Removendo um elemento pelo índice
        Integer removedElement = linkedList.remove(2);  // Remove o elemento na posição 2 (30)
        System.out.println("Elemento removido da posição 2: " + removedElement);
        System.out.println("Após remover o elemento na posição 2: " + linkedList);

        // Removendo um elemento específico
        boolean removed = linkedList.removeAll(40);  // Remove todos os 40 da lista
        System.out.println("Elemento 40 removido: " + removed);
        System.out.println("Após remover todos os 40: " + linkedList);

        // Verificando se um elemento existe na lista
        boolean contains = linkedList.contains(20);  // Verifica se o elemento 20 está na lista
        System.out.println("Lista contém 20? " + contains);

        // Obtendo um elemento pelo índice
        Integer elementAtIndex = linkedList.get(2);  // Obtém o elemento na posição 2
        System.out.println("Elemento na posição 2: " + elementAtIndex);

        // Alterando um elemento
        Integer oldData = linkedList.set(1, 100);  // Altera o elemento na posição 1 para 100
        System.out.println("Elemento alterado da posição 1 (de " + oldData + " para 100): " + linkedList);

        // Verificando o comprimento da lista
        int length = linkedList.length();
        System.out.println("Comprimento da lista: " + length);

        // Concatenando outra lista
        Integer[] newElements = {70, 80, 90};
        LinkedList<Integer> newList = new LinkedList<>(newElements);
        list.concat(newList);
        System.out.println("Após concatenar com outra lista: " + list);

        // Limpar a lista
        list.clear();
        System.out.println("Após limpar a lista: " + list);

        // Verificando se a lista está vazia
        boolean isEmpty = list.isEmpty();
        System.out.println("A lista está vazia? " + isEmpty);
        // Testando a Lista Duplamente Encadeada
        System.out.println("\nLista Duplamente Encadeada:");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        for (int element : elements) {
            doublyLinkedList.add(element);
        }
        doublyLinkedList.traverseForward(); // Saída: 10 20 30 40 50 60
        doublyLinkedList.traverseBackward(); // Saída: 60 50 40 30 20 10

        // Testando a Lista Circular
        System.out.println("\nLista Circular:");
        CircularList circularList = new CircularList(4); // Tamanho fixo 4

        int index = 0;
        while (index < elements.length) {
            // Preenche a lista até ficar cheia
            while (circularList.getSize() < 4 && index < elements.length) {
                circularList.add(elements[index]);
                index++;
            }
            System.out.println("Após adicionar elementos:");
            circularList.traverseWithIndex();

            // Remove dois elementos
            System.out.println("Removendo dois elementos:");
            for (int i = 0; i < 2 && !circularList.isEmpty(); i++) {
                System.out.println("Removido: " + circularList.remove());
            }
            circularList.traverseWithIndex();
        }

        System.out.println("\nÁrvore Binária:");
        BinaryTree arvoreBinaria = new BinaryTree();

        Node raiz = arvoreBinaria.insertRoot(10);

        Node filhoEsquerdo = arvoreBinaria.insertNode(5, raiz, BinaryTree.Side.LEFT);
        Node filhoDireito = arvoreBinaria.insertNode(15, raiz, BinaryTree.Side.RIGHT);

        arvoreBinaria.insertNode(3, filhoEsquerdo, BinaryTree.Side.LEFT);
        arvoreBinaria.insertNode(7, filhoEsquerdo, BinaryTree.Side.RIGHT);

        arvoreBinaria.insertNode(8, filhoDireito, BinaryTree.Side.LEFT);

        // Testando a Árvore Binária
        System.out.println("\nÁrvore Binária em Pré-Ordem:");
        arvoreBinaria.printPreOrder(arvoreBinaria.getRoot());  // Exibe em pré-ordem
        System.out.println();

        System.out.println("\nÁrvore Binária em Ordem:");
        arvoreBinaria.printInOrder(arvoreBinaria.getRoot());  // Exibe em ordem
        System.out.println();

        System.out.println("\nÁrvore Binária em Pós-Ordem:");
        arvoreBinaria.printPostOrder(arvoreBinaria.getRoot());  // Exibe em pós-ordem
        System.out.println();

        // Testando a Fila de Prioridade
        System.out.println("\nFila de Prioridade:");
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enqueue(10, 2);
        priorityQueue.enqueue(20, 1);
        priorityQueue.enqueue(30, 3);
        priorityQueue.enqueue(40, 0);
        priorityQueue.enqueue(50, 5);

        // Removendo da fila de prioridade
        while (!priorityQueue.isEmpty()) {
            System.out.println("Dequeue (com prioridade): " + priorityQueue.dequeue());
        }
    }
}