class Solution {
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        int dp[][]=new int[n+1][amt+1];
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=amt;j++) dp[0][j]=Integer.MAX_VALUE-1;
        for(int j=1;j<=amt;j++){
            if(j%coins[0]==0) dp[1][j]=j/coins[0];
            else dp[1][j]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amt;j++){
                if(coins[i-1]<=j) dp[i][j]=Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][amt]==Integer.MAX_VALUE-1 ? -1 : dp[n][amt];
    }
}