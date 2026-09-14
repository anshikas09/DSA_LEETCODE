class Solution {
    public int maxProfit(int k, int[] p) {
        int n=p.length;
        int [][][]dp= new int [n+1][2][k+1];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy==1){
                        int take = -p[i]+dp[i+1][0][cap];
                        int skip = dp[i+1][1][cap];
                        dp[i][buy][cap]=Math.max(take,skip);
                    }
                    else {
                        int take=p[i]+dp[i+1][1][cap-1];
                        int skip = dp[i+1][0][cap];
                        dp[i][buy][cap]=Math.max(take,skip);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}