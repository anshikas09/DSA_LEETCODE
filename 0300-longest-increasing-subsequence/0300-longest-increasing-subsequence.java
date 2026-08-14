class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [][]dp=new int[n+1][n+1];
        for(int idx=n-1;idx>=0;idx--){
            for(int prev=idx-1;prev>=-1;prev--){
                int len1=dp[idx+1][prev+1];
                int len2=0;
                if(prev==-1 || nums[idx]>nums[prev]) len2=1+dp[idx+1][idx+1];
                dp[idx][prev+1]=Math.max(len1,len2);
            }
            
        }
        return dp[0][-1+1];
    }
    
}