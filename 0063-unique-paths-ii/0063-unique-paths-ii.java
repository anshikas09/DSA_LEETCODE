class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new int[n][m];
        for(int []r:dp) Arrays.fill(r,-1);
        return solve(0,0,n,m,grid);
    }
    public int solve(int i, int j, int n, int m,int [][]grid){
        if(i>=n || j>=m) return 0;
        if(grid[i][j]==1) return 0;
        if(i==n-1 && j==m-1) return 1;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int right=solve(i,j+1,n,m,grid);
        int down=solve(i+1,j,n,m,grid);
        
        return dp[i][j]=right+down;
    }
}