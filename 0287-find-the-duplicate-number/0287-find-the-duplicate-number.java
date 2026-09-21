class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=0;
        for(int i=1;i<n;i++){
            
                if(nums[i]==nums[i-1]) ans= nums[i];
            
        }
        return ans;
    }
}