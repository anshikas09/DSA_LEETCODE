class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int x:nums) total+=x;
        if(Math.abs(target)>total || (total+target)%2!=0) return 0;
        int s1= (total+target)/2;
        return countSubset(nums,s1);
    }
    private int countSubset(int []nums, int sum){
        int n=nums.length;
        int dp[][]=new int[n+1][sum+1];
        dp[0][0] = 1; 
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(nums[i-1]<=j) dp[i][j]=dp[i-1][j] + dp[i-1][j-nums[i-1]];
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}