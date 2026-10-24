class Solution {
    public int largestRectangleArea(int[] ht) {
        Stack<Integer> st = new Stack<>();
        int n=ht.length;
        int max=0;
        for(int i=0;i<=n;i++){
            int h = (i==n) ? 0:ht[i];
            while(!st.isEmpty() && h<ht[st.peek()]){
                int top = st.pop();
                int width = st.isEmpty()? i: i-st.peek()-1;
                max=Math.max(max,ht[top]*width);
            }
            st.push(i);
        }
        return max;
    }
}