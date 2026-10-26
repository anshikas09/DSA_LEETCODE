class MinStack {
    Stack<Integer> min =new Stack<>();
    Stack<Integer> st=new Stack<>();;
    public MinStack() {

    }
    
    public void push(int value) {
        if(st.size()==0){
            st.push(value);
            min.push(value);
        }else{
            st.push(value);
            if(min.peek()<value) min.push(min.peek());
            else min.push(value);
        }  
    }
    
    public void pop() {
        if(!st.isEmpty()) st.pop();
        if(!min.isEmpty()) min.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */