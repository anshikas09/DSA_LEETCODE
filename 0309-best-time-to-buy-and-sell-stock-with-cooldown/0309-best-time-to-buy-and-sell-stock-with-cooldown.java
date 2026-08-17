class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        // dp[n] and dp[n+1] are automatically 0

        for (int i = n - 1; i >= 0; i--) {

            // Can buy
            dp[i][1] = Math.max(
                    -prices[i] + dp[i + 1][0],
                    dp[i + 1][1]
            );

            // Holding stock
            dp[i][0] = Math.max(
                    prices[i] + dp[i + 2][1],
                    dp[i + 1][0]
            );
        }

        return dp[0][1];
    }
}