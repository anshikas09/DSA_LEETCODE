class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st= new Stack<>();
        StringBuilder sb= new StringBuilder();
        int n=num.length();
        for(int i=0;i<n;i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && ch < st.peek() && k>0) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        while(!st.isEmpty()) sb.append(st.pop());
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0') sb.deleteCharAt(0);
        if(sb.length()==0) return "0";
        return sb.toString();

    }
}