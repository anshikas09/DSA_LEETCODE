class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
    }
    private void bfs(int i, int j, int [][]vis, char[][]grid){
        vis[i][j]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        int delRow[]={-1,0,1,0};
        int delCol[]={0,-1,0,1};
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int r=curr.first;
            int c=curr.second;
            for(int k=0;k<4;k++){
                int nr=r+delRow[k];
                int nc=c+delCol[k];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]=='1'){
                    vis[nr][nc]=1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
    }
}