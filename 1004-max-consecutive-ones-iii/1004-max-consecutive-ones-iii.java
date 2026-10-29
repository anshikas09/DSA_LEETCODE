class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int cnt=0;
        int max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0) cnt++;
            while(cnt>k){
                if(nums[l]==0) cnt--;
                l++;
            }
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}