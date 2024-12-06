package revisao_ed_antonio.c_queue;

public class Queue {
	    private int[] elementos;
	    private int frente, traseira, tamanho;

	    public Queue(int capacidade) {
	        elementos = new int[capacidade];
	        frente = 0;
	        traseira = -1;
	        tamanho = 0;
	    }

	    public void enqueue(int elemento) {
	        if (tamanho == elementos.length) {
	            throw new RuntimeException("Fila cheia");
	        }
	        traseira = (traseira + 1) % elementos.length;
	        elementos[traseira] = elemento;
	        tamanho++;
	    }

	    public int dequeue() {
	        if (isEmpty()) {
	            throw new RuntimeException("Fila vazia");
	        }
	        int elemento = elementos[frente];
	        frente = (frente + 1) % elementos.length;
	        tamanho--;
	        return elemento;
	    }

	    public boolean isEmpty() {
	        return tamanho == 0;
	    }
	}