import java.util.Stack;

public class PriorityQueue_Via_Stacks {

    Stack<Integer> q1 = new Stack<>();
    Stack<Integer> q2 = new Stack<>();

    public void Insertion(int x) {
        while (!q2.isEmpty() && q2.peek() < x) {
            q1.push(q2.pop());
        }
        q2.push(x);
        while (!q1.isEmpty()) {
            q2.push(q1.pop());
        }
    }

    public int Extract_Min() {
        return q2.pop();
    }

    public static void main(String[] args) {
        PriorityQueue_Via_Stacks q = new PriorityQueue_Via_Stacks();

        q.Insertion(100);
        q.Insertion(17);
        q.Insertion(1);
        q.Insertion(24);
        q.Insertion(85);
        q.Insertion(9);

        System.out.println("Extracted Min: " + q.Extract_Min());
    }
}
