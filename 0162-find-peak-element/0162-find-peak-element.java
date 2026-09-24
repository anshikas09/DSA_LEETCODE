class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        for(int i=1;i<n-1;i++){
            if(nums[i-1]<nums[i] && nums[i]>nums[i+1]) return i;
        }
        if (n == 1 || nums[0] > nums[1]) {
            return 0;
        }
        return n-1;
    }
}