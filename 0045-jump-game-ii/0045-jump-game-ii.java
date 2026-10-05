class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int curr=0;
        int farthest=0;
        int jumps=0;
        for(int i=0;i<n-1;i++){
            farthest=Math.max(farthest,nums[i]+i);
            if(i==curr){
                jumps++;
                curr=farthest;
            }
        }
        return jumps;
    }
}