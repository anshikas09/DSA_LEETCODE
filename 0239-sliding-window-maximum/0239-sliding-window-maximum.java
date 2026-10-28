class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int idx=0;
        Deque<Integer> dq= new LinkedList<>();
        int result[]=new int[n-k+1];
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()==i-k) dq.pollFirst();
            while(!dq.isEmpty() && nums[dq.peekLast()]< nums[i]) dq.pollLast();
            dq.offerLast(i);
            if(i>=k-1) result[idx++]=nums[dq.peekFirst()];
        }
        return result;
    }
}