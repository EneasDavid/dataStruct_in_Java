package revisao_ed_antonio.c_queue;

import java.util.ArrayList;

public class PriorityQueue {
    private class Element {
        int value;
        int priority;

        Element(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    private ArrayList<Element> heap;

    public PriorityQueue() {
        heap = new ArrayList<>();
    }

    public void enqueue(int value, int priority) {
        Element newElement = new Element(value, priority);
        heap.add(newElement);
        heapifyUp(heap.size() - 1);
    }

    public int dequeue() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Priority queue is empty");
        }
        int value = heap.get(0).value;
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return value;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).priority < heap.get(parentIndex).priority) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChild, rightChild, smallest;

        while ((leftChild = 2 * index + 1) < heap.size()) {
            rightChild = 2 * index + 2;
            smallest = index;

            if (heap.get(leftChild).priority < heap.get(smallest).priority) {
                smallest = leftChild;
            }

            if (rightChild < heap.size() && heap.get(rightChild).priority < heap.get(smallest).priority) {
                smallest = rightChild;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Element temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}