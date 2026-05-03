import java.util.ArrayList;

public class Heaparray {
    ArrayList<Integer> arr = new ArrayList<>();

    public void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    private void siftUp(int i) {
        int parent = (i - 1) / 2;
        if (parent >= 0 && arr.get(parent) > arr.get(i)) {
            swap(i, parent);
            siftUp(parent);
        }
    }

    private void siftDown(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;
        if (l < arr.size() && arr.get(l) < arr.get(smallest)) smallest = l;
        if (r < arr.size() && arr.get(r) < arr.get(smallest)) smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            siftDown(smallest);
        }
    }

    public void add(int val) {
        arr.add(val);
        siftUp(arr.size() - 1);
    }

    public int extractMin() {
        if (arr.isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = arr.get(0);
        int last = arr.remove(arr.size() - 1);
        if (!arr.isEmpty()) {
            arr.set(0, last);
            siftDown(0);
        }
        return min;
    }

    public void print() {
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heaparray h = new Heaparray();
        h.add(1);
        h.add(52);
        h.add(11);
        h.add(33);
        h.add(3);
        h.add(13);
        h.add(27);
        h.add(6);

        h.print();
        h.add(9);
        h.add(-1);
        h.print();
        h.extractMin();
        h.extractMin();
        h.print();
    }
}
