class Solution {

    public int maxProfit(int[] prices) {

        int[][] next = new int[2][3];

        for (int i = prices.length - 1; i >= 0; i--) {

            int[][] curr = new int[2][3];

            for (int buy = 0; buy <= 1; buy++) {

                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {

                        // Buy
                        int take = -prices[i]
                                + next[0][cap];

                        // Skip
                        int skip =
                                next[1][cap];

                        curr[buy][cap] =
                                Math.max(take, skip);

                    } else {

                        // Sell
                        int take = prices[i]
                                + next[1][cap - 1];

                        // Skip
                        int skip =
                                next[0][cap];

                        curr[buy][cap] =
                                Math.max(take, skip);
                    }
                }
            }

            next = curr;
        }

        return next[1][2];
    }
}