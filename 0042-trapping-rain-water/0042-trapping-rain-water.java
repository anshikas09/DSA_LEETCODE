class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int n=height.length;
        int res=0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && height[i]>height[st.peek()]){
                int top=height[st.pop()];
                if(st.isEmpty()) break;
                int dist=i-st.peek()-1;
                int water=Math.min(height[i],height[st.peek()]);
                water-=top;
                res+=water*dist;
            }
            st.push(i);
        }
        return res;
    }
}