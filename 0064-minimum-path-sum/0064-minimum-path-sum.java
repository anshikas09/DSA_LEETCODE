class Solution {
    static int [][]dp;
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        dp=new int[m][n];
        for(int []r:dp){
            Arrays.fill(r,-1);
        }
        return solve(grid,m,n,0,0);
    }
    private int solve(int[][]grid, int m, int n, int i, int j){
        if(i==m-1 && j==n-1) dp[i][j]=grid[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int down=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        if (i<m-1) {
            down = solve(grid,m,n,i+1,j);
        }
        if (j<n-1) {
            right = solve(grid,m,n,i,j+1);
        }
        dp[i][j]=grid[i][j]+Math.min(right,down);
        return dp[i][j];
    }
}