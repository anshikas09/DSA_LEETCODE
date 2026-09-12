class Solution {
    int dp[];
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        dp=new int[n];
        Arrays.fill(dp,-1);
        int ans1=solve(0,nums,n-1);
        Arrays.fill(dp,-1);
        int ans2=solve(1,nums,n);
        return Math.max(ans1,ans2);
    }
    public int solve(int i, int[]nums,int n){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick = nums[i]+solve(i+2,nums,n);
        int skip = solve(i+1,nums,n);
        return dp[i]=Math.max(pick,skip);
    }
}