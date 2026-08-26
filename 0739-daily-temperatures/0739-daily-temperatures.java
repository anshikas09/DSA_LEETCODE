class Solution {
    public int[] dailyTemperatures(int[] t) {
        Stack<Integer> st= new Stack<>();
        int res[]= new int [t.length];
        for(int i=0;i<t.length;i++){
            while(!st.isEmpty() && t[i]>t[st.peek()]){
                int idx= st.pop();
                res[idx]=i-idx;
            }
            st.push(i);
        }
        return res;
    }
}