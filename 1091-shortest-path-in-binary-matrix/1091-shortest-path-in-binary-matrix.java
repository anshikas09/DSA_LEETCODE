class Solution {
    static class Pair{
        int row,col,dist;
        Pair(int row, int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int[]dr={-1,-1,-1,0,1,1,1,0};
        int[]dc={-1,0,1,1,1,0,-1,-1};
        Queue<Pair> q=new LinkedList<>();
        boolean[][]vis=new boolean[n][n];
        q.add(new Pair(0,0,1));
        vis[0][0]=true;
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int r=curr.row;
            int c=curr.col;
            int dist=curr.dist;
            if(r==n-1 && c==n-1) return dist;
            for(int i=0;i<8;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    q.add(new Pair(nr,nc,dist+1));
                }
            }
        }
        return -1;
    }
}