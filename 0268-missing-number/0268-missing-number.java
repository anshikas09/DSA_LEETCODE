class Solution {
    public int missingNumber(int[] nums) {
        int s=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            s+=nums[i];
        }
        int sum=n*(n+1)/2;
        return sum-s;
    }
}