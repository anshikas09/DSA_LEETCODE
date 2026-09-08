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
    public int findCircleNum(int[][] isConnected) {
        int cnt=0;
        int n=isConnected.length;
        DSU ds=new DSU(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1) ds.union(i,j);
            }
        }
        for(int i=0;i<n;i++){
            if(ds.find(i)==i) cnt++;
        }
        return cnt;
    }
}