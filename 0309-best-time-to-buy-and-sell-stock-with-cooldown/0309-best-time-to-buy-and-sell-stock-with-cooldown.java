class Solution {
    int dp[][];
    public int solve(int[] prices, int i, int buy) {
        if (i >= prices.length) {
            return 0;
        }

        if(dp[i][buy]!=-1) return dp[i][buy];
        if (buy == 1) {
            int take = -prices[i] + solve(prices, i + 1, 0);
            int skip = solve(prices, i + 1, 1);
            return dp[i][buy]=Math.max(take, skip);

        } else {
            int take = prices[i] + solve(prices, i + 2, 1);
            int skip = solve(prices, i + 1, 0);
            return dp[i][buy]=Math.max(take, skip);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][2];
        for(int[]r:dp) Arrays.fill(r,-1);
        return solve(prices, 0, 1);
    }
}