class Node {
    public Object data;
    public Node next;

    public Node(Object o) {
        this.data = o;
        this.next = null;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

public class Custom_LinkedList {
    private Node head;

    public Custom_LinkedList() {
        head = null;
    }

    public void insertFirst(Object o) {
        Node newNode = new Node(o);
        newNode.next = head;
        head = newNode;
    }

    public Object removeFirst() {
        if (isEmpty()) return null;
        Object res = head.data;
        head = head.next;
        return res;
    }

    public Object getFirst() {
        if (isEmpty()) return null;
        return head.data;
    }

    public void insertLast(Object o) {
        Node newNode = new Node(o);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null)
            current = current.next;
        current.next = newNode;
    }

    public Object removeLast() {
        if (isEmpty()) return null;
        if (head.next == null) {
            Object res = head.data;
            head = null;
            return res;
        }
        Node current = head;
        while (current.next.next != null)
            current = current.next;
        Object res = current.next.data;
        current.next = null;
        return res;
    }

    public Object getLast() {
        if (isEmpty()) return null;
        Node current = head;
        while (current.next != null)
            current = current.next;
        return current.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        if (head == null) return "[ ]";
        StringBuilder res = new StringBuilder("[ " + head.data);
        Node current = head.next;
        while (current != null) {
            res.append(", ").append(current.data);
            current = current.next;
        }
        res.append(" ]");
        return res.toString();
    }

    public void reverse() {
        if (head == null || head.next == null) return;

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        Custom_LinkedList list = new Custom_LinkedList();
        for (int i = 1; i <= 9; i++) {
            list.insertFirst(i);
        }

        System.out.println("Original List: " + list);
        list.reverse();
        System.out.println("Reversed List: " + list);
    }
}