package revisao_ed_antonio.b_Stack;

public class Stack {
    private int[] elementos;
    private int topo;

    public Stack(int capacidade) {
        elementos = new int[capacidade];
        topo = -1;
    }

    public void push(int elemento) {
        if (topo == elementos.length - 1) {
            throw new RuntimeException("Pilha cheia");
        }
        elementos[++topo] = elemento;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia");
        }
        return elementos[topo--];
    }

    public boolean isEmpty() {
        return topo == -1;
    }
    
}