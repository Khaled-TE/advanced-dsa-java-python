class StackNode {
    Object data;
    StackNode next;

    public StackNode(Object data){
        this.data = data;
        next = null;
    }

    public String toString(){
        return data + "";
    }
}

public class Custom_Stack {
    StackNode top;
    int size;

    public Custom_Stack(){
        top = null;
        size = 0;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(Object d){
        StackNode newNode = new StackNode(d);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public Object pop(){
        if(isEmpty()) return null;
        Object res = top.data;
        top = top.next;
        size--;
        return res;
    }

    public Object top(){
        if(isEmpty()) return null;
        return top.data;
    }

    public String toString(){
        if(isEmpty()) return "Empty!";
        String res = "";
        StackNode curr = top;
        while(curr!=null){
            res += curr;
            if(curr == top) res+= " <-- top";
            res += "\n";
            curr = curr.next;
        }
        return res;
    }

    public static Custom_Stack[] decompose(Custom_Stack s){
        Custom_Stack x = new Custom_Stack();
        Custom_Stack y = new Custom_Stack();
        Custom_Stack temp1 = new Custom_Stack();
        Custom_Stack temp2 = new Custom_Stack();

        boolean toFirst = true;
        while(!s.isEmpty()){
            if(toFirst) temp1.push(s.pop());
            else temp2.push(s.pop());
            toFirst = !toFirst;
        }
        while(!temp1.isEmpty()) x.push(temp1.pop());
        while(!temp2.isEmpty()) y.push(temp2.pop());
        return new Custom_Stack[]{x, y};
    }

    public static void main(String[] args) {
        Custom_Stack s = new Custom_Stack();
        s.push(5); s.push(4); s.push(-1); s.push(2);
        s.push(3); s.push(17); s.push(8); s.push(11);

        System.out.println("Original Stack:\n" + s);
        Custom_Stack[] parts = decompose(s);
        System.out.println("First half:\n" + parts[0]);
        System.out.println("Second half:\n" + parts[1]);
    }
}