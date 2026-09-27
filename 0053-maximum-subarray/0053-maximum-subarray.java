class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=nums[0];
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            if(maxsum<sum){
                maxsum=sum;
            }
            if(sum<0) sum=0;
        }
        return maxsum;
    }
}