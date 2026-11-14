class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else if(st.size()>0){
                char top=st.peek();
                if(ch == ')') {
                    if(top == '(') st.pop();
                    else return false;
                }
                if(ch == '}') {
                    if(top == '{') st.pop();
                    else return false;
                }
                if(ch == ']') {
                    if(top == '[') st.pop();
                    else return false;
                }
            }else return false;
        }
        if(st.size()>0) return false;
        return true;
    }
}