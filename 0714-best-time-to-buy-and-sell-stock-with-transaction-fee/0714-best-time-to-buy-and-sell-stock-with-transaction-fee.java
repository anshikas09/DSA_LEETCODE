class Solution {

    public int maxProfit(int[] prices, int fee) {

        int nextBuy = 0;
        int nextNotBuy = 0;

        for (int i = prices.length - 1; i >= 0; i--) {

            // Can buy
            int currentBuy = Math.max(
                    -prices[i] + nextNotBuy,
                    nextBuy
            );

            // Holding stock
            int currentNotBuy = Math.max(
                    prices[i] - fee + nextBuy,
                    nextNotBuy
            );

            // Move current -> next
            nextBuy = currentBuy;
            nextNotBuy = currentNotBuy;
        }

        return nextBuy;
    }
}