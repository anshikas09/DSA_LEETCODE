class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else if(!st.isEmpty()){
                if(ch == ')' || ch  == '}' || ch ==']'){
                    char top=st.peek();
                    if(ch == ')'){
                        if(top!='(') return false;
                        else st.pop();
                    }
                    if(ch == '}'){
                        if(top!='{') return false;
                        else st.pop();
                    }
                    if(ch == ']'){
                        if(top!='[') return false;
                        else st.pop();
                    }
                }
            }else return false;
        }
        return st.isEmpty();
    }
}