class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums,0,-1);
    }
    public int solve(int []nums, int idx, int prev){
        if(idx==nums.length) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int len1=solve(nums,idx+1,prev);
        int len2=0;
        if(prev==-1|| nums[idx]>nums[prev]){
            len2=1+solve(nums,idx+1,idx);
        }
        return dp[idx][prev+1]=Math.max(len1,len2);
    }
}