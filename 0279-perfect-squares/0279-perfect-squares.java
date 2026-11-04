class Solution {
    public int numSquares(int n) {

        int m = (int)Math.sqrt(n);
        int[] arr = new int[m];

        for(int i=1; i<=m; i++) {
            arr[i-1] = i*i;
        }

        int[][] dp = new int[m][n+1];

        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(m-1, n, arr, dp);
    }

    public int solve(int i, int target, int[] arr, int[][] dp) {

        if(target == 0) return 0;

        if(i < 0) return 100000;

        if(dp[i][target] != -1) return dp[i][target];

        int notTake = solve(i-1, target, arr, dp);

        int take = 100000;

        if(arr[i] <= target) {
            take = 1 + solve(i, target-arr[i], arr, dp);
        }

        return dp[i][target] = Math.min(take, notTake);
    }
}