public class SpecialStack {
    Custom_Stack s;
    Custom_Stack min;

    public SpecialStack(){
        s = new Custom_Stack();
        min = new Custom_Stack();
    }

    public void push(Object d){
        if(s.isEmpty()){
            s.push(d);
            min.push(d);
        }
        else if((int)d > (int)min.top()){
            s.push(d);
            min.push(min.top());
        }
        else{
            s.push(d);
            min.push(d);
        }
    }

    public Object pop(){
        if(s.isEmpty()) return null;
        Object res = s.pop();
        min.pop();
        return res;
    }

    public Object getmin(){
        return min.top();
    }

    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();
        s.push(5);
        s.push(4);
        s.push(-1);
        s.push(2);
        s.push(3);
        s.push(17);
        s.push(8);
        s.push(11);

        System.out.println("Minimum element is: " + s.getmin());
    }
}