class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int left=0;
        double maxsum= Double.NEGATIVE_INFINITY;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            if(right-left+1>k){
                sum-=nums[left];
                left++;
            }
            if(right-left+1==k){
                maxsum=Math.max(sum,maxsum);
            }
        }
        return maxsum/k;
    }
}