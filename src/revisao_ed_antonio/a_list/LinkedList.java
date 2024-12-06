package revisao_ed_antonio.a_list;

public class LinkedList<T> {
    protected Node<T> head;

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public LinkedList() {

    }

    public LinkedList(T[] array) {
        this.head = null;
        if (array != null && array.length > 0) {
            this.head = new Node<T>(array[0]);
            Node<T> rear = this.head;
            int i = 1;
            while (i < array.length) {
                rear.next = new Node<T>(array[i++]);
                rear = rear.next;
            }
        }
    }

    public LinkedList(LinkedList<T> list) {
        this.head = null;
        if (list != null && list.head != null) {
            this.head = new Node<>(list.head.data);
            Node<T> p = list.head.next;
            Node<T> rear = this.head;
            while (p != null) {
                rear.next = new Node<T>(p.data);
                rear = rear.next;
                p = p.next;
            }
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int length() {
        int length = 0;
        Node<T> p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        return length;
    }

    public T get(int index) {
        if (this.head != null && index >= 0) {
            int count = 0;
            Node<T> p = this.head;
            while (p != null && count < index) {
                p = p.next;
                count++;
            }

            if (p != null) {
                return p.data;
            }
        }
        return null;
    }

    public T set(int index, T data) {
        if (this.head != null && index >= 0 && data != null) {
            Node<T> pre = this.head;
            int count = 0;
            while (pre != null && count < index) {
                pre = pre.next;
                count++;
            }

            if (pre != null) {
                T oldData = pre.data;
                pre.data = data;
                return oldData;
            }
        }
        return null;
    }

    public boolean add(int index, T data) {
        if (data == null) {
            return false;
        }
        if (this.head == null || index <= 1) {
            this.head = new Node<T>(data, this.head);
        } else {
            int count = 0;
            Node<T> front = this.head;
            while (front.next != null && count < index - 1) {
                front = front.next;
                count++;
            }
            front.next = new Node<T>(data, front.next);
        }
        return true;
    }

    public boolean add(T data) {
        return add(Integer.MAX_VALUE, data);
    }

    public T remove(int index) {
        T old = null;

        if (this.head != null && index >= 0) {
            if (index == 0) {
                old = this.head.data;
                this.head = this.head.next;
            } else {
                Node<T> front = this.head;
                int count = 0;
                while (front.next != null && count < index - 1) {
                    front = front.next;
                    count++;
                }

                if (front.next != null) {
                    old = front.next.data;
                    front.next = front.next.next;
                }
            }
        }
        return old;
    }

    public boolean removeAll(T data) {
        boolean isRemove = false;

        if (this.head != null && data != null) {
            if (data.equals(this.head.data)) {
                this.head = this.head.next;
                isRemove = true;
            }

            Node<T> front = this.head;
            Node<T> pre = front.next;
            while (pre != null) {
                if (data.equals(pre.data)) {
                    front.next = pre.next;
                    pre = front.next;
                    isRemove = true;
                } else {
                    front = pre;
                    pre = pre.next;
                }
            }
        }
        return isRemove;
    }

    public void clear() {
        this.head = null;
    }

    public boolean contains(T data) {
        if (this.head != null && data != null) {
            Node<T> pre = this.head;
            while (pre != null) {
                if (data.equals(pre.data)) {
                    return true;
                }
                pre = pre.next;
            }
        }
        return false;
    }

    public void concat(LinkedList<T> list) {
        if (this.head == null)
            this.head = list.head;
        else {
            Node<T> pre = this.head;
            while (pre.next != null)
                pre = pre.next;
            pre.next = list.head;
        }
    }

    @Override
    public String toString() {
        String str = "(";
        Node<T> pre = this.head;
        while (pre != null) {
            str += pre.data;
            pre = pre.next;
            if (pre != null)
                str += ", ";
        }
        return str + ")";
    }
}