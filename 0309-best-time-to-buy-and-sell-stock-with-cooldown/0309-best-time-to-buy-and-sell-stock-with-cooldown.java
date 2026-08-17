class Solution {

    public int maxProfit(int[] prices) {

        int nextBuy = 0;
        int nextNotBuy = 0;

        int nextNextBuy = 0;

        for (int i = prices.length - 1; i >= 0; i--) {

            // Can buy
            int currentBuy = Math.max(
                    -prices[i] + nextNotBuy,
                    nextBuy
            );

            // Holding stock
            int currentNotBuy = Math.max(
                    prices[i] + nextNextBuy,
                    nextNotBuy
            );

            // Shift states
            nextNextBuy = nextBuy;

            nextBuy = currentBuy;
            nextNotBuy = currentNotBuy;
        }

        return nextBuy;
    }
}