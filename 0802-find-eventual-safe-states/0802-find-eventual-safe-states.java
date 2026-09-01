class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int vis[]=new int[n];
        int pathvis[]=new int[n];
        int check[]=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0) dfs(i,graph,vis,pathvis,check);
        }
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1) ans.add(i);
        }
        return ans;
    }
    private boolean dfs(int node, int[][]graph, int[]vis, int[]pathvis, int []check){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        int n=graph.length;
        for(int i: graph[node]){
            if(vis[i]==0) {
                if(dfs(i,graph,vis,pathvis,check)) return true;
            }
            else if(pathvis[i]==1) return true;
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }
}