class Solution {
    public int findCircleNum(int[][] mat) {
        int n=mat.length;
        boolean[]vis=new boolean[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,mat,vis);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int node, int[][]mat, boolean[]vis){
        vis[node]=true;
        for(int i=0;i<mat.length;i++){
            if(!vis[i]&& mat[node][i]==1) dfs(i,mat,vis);
        }
    }
}