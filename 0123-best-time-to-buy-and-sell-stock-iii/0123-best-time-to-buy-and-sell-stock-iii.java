class Solution {
    int dp[][][];
    public int solve(int[] prices, int i, int buy, int cap) {
        if (i == prices.length || cap == 0) {
            return 0;
        }
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        if (buy == 1) {
            int take = -prices[i] + solve(prices, i + 1, 0, cap);
            int skip = solve(prices, i + 1, 1, cap);
            return dp[i][buy][cap]= Math.max(take, skip);

        } else {
            int take = prices[i] + solve(prices, i + 1, 1, cap - 1);
            int skip = solve(prices, i + 1, 0, cap);
            return dp[i][buy][cap]=Math.max(take, skip);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int buy=0;buy<2;buy++){
                Arrays.fill(dp[i][buy],-1);
            }
        }
        return solve(prices, 0, 1, 2);
    }
}