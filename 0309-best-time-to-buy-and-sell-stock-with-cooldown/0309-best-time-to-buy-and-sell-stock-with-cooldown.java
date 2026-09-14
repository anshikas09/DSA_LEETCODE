class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;
        int dp[][]=new int[n+2][2];
        for(int i=n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                if(buy==1){
                    int take = -p[i]+dp[i+1][0];
                    int skip = dp[i+1][1];
                    dp[i][buy]=Math.max(take,skip);
                }
                else{
                    int take = p[i]+dp[i+2][1];
                    int skip =dp[i+1][0];
                    dp[i][buy]=Math.max(take,skip);
                }
            }
        }
        return dp[0][1]; 
    }
}