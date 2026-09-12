class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        dp=new int[n][m]; 
        for(int r[]:dp) Arrays.fill(r,-1);
        return solve(0,0,n,m,grid);
    }
    int solve(int i, int j, int n, int m, int[][]grid){
        if(i==n-1 && j==m-1) return grid[i][j];
        if(i>=n || j>=m) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int right= solve(i,j+1,n,m,grid);
        int down = solve(i+1,j,n,m,grid);
        return dp[i][j]=Math.min(right,down)+grid[i][j];
    }
}