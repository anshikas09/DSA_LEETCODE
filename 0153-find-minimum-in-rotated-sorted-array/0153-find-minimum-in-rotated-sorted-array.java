class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int st=0;
        int end=n-1;
        int ans=nums[0];
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[0]<=nums[mid]){
                st=mid+1;
            }else {
                ans=nums[mid];
                end=mid-1;
            }
        }
        return ans;
    }
}