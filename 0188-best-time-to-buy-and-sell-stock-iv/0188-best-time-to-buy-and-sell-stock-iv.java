class Solution {

    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        int[][][] dp = new int[n + 1][2][k + 1];

        // dp[n][buy][cap] = 0
        // No days remaining

        for (int i = n - 1; i >= 0; i--) {

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 1; cap <= k; cap++) {

                    if (buy == 1) {

                        // Buy
                        int take = -prices[i]
                                + dp[i + 1][0][cap];

                        // Skip
                        int skip =
                                dp[i + 1][1][cap];

                        dp[i][buy][cap] =
                                Math.max(take, skip);

                    } else {

                        // Sell
                        int take = prices[i]
                                + dp[i + 1][1][cap - 1];

                        // Skip
                        int skip =
                                dp[i + 1][0][cap];

                        dp[i][buy][cap] =
                                Math.max(take, skip);
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}