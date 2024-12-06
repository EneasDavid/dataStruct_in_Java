package revisao_ed_antonio.a_list;
public class DoublyLinkedList {
    private class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head; 
    private Node tail; 

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) { 
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void remove(int value) {
        if (head == null) return; 

        Node current = head;

        while (current != null) {
            if (current.value == value) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; 
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; 
                }

                return;
            }
            current = current.next;
        }
    }

    public void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void traverseBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }
}