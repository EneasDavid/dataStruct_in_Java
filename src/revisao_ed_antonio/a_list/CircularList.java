package revisao_ed_antonio.a_list;

public class CircularList {
    private int[] elements;
    private int front, rear, size;

    public CircularList(int capacity) {
        elements = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void add(int element) {
        if (size == elements.length) {
            throw new RuntimeException("Circular list is full");
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("Circular list is empty");
        }
        int element = elements[front];
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void traverseWithIndex() {
        if (isEmpty()) {
            System.out.println("A lista está vazia.");
            return;
        }

        System.out.println("Índice - Valor");
        int current = front;
        for (int i = 0; i < size; i++) {
            System.out.println(current + " - " + elements[current]);
            current = (current + 1) % elements.length;
        }
    }
}