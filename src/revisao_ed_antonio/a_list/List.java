package revisao_ed_antonio.a_list;

import java.util.ArrayList;

public class List {

    private ArrayList<Integer> list;

    public List() {
        list = new ArrayList<>();
    }

    public void add(int element) {
        list.add(element);
    }

    public void remove(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        list.remove(index);
    }

    public int get(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return list.get(index);
    }
}