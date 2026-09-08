class Solution {
    class DSU{
        int parent[];
        int size[];
        DSU(int n){
            parent=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int find(int x){
            if(parent[x]==x) return x;
            return parent[x]=find(parent[x]);
        }
        void union(int u, int v){
            int pu=find(u);
            int pv=find(v);
            if(pu==pv) return;
            if(size[pu]<size[pv]){
                parent[pu]=pv;
                size[pv]+=size[pu];
            }
            else{
                parent[pv]=pu;
                size[pu]+=size[pv];
            }
        }
    }
    //public int findCircleNum(int[][] isConnected) {
    //     int cnt=0;
    //     int n=isConnected.length;
    //     DSU ds=new DSU(n);
    //     for(int i=0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(isConnected[i][j]==1) ds.union(i,j);
    //         }
    //     }
    //     for(int i=0;i<n;i++){
    //         if(ds.find(i)==i) cnt++;
    //     }
    //     return cnt;
    // }
    public int makeConnected(int n, int[][] connections) {
        int cnt=0;
        int cntExtra=0;
        DSU ds=new DSU(n);
        int m=connections.length;
        for(int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.find(u)==ds.find(v)) cntExtra++;
            else ds.union(u,v);
        }
        for(int i=0;i<n;i++){
            if(ds.find(i)==i) cnt++;
        }
        int ans=cnt-1;
        if(cntExtra>=ans) return ans;
        return -1;
    }
}