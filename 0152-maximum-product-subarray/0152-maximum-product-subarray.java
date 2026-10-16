class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int min=nums[0];
        int max=nums[0];
        int maxpro=nums[0];
        for(int i=1;i<n;i++){
            int a=nums[i]*max;
            int b=nums[i]*min;
            max=Math.max(nums[i],Math.max(a,b));
            min=Math.min(nums[i],Math.min(a,b));
            maxpro=Math.max(max,maxpro);
        }
        return maxpro;
    }
}