class Solution {
    public int[] twoSum(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        while(i<j){
            if(nums[i]+nums[j]==k) return new int[]{i+1,j+1};
            else if(nums[i]+nums[j]>k) j--;
            else i++;
        }
        return new int[]{-1,-1};
    }
}