class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) return x;

            return parent[x] = find(parent[x]);
        }

        void union(int u, int v) {

            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            }
            else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
    public int removeStones(int[][] stones) {
        int maxrow=0, maxcol=0;
        for(int []stone:stones){
            maxrow=Math.max(maxrow,stone[0]);
            maxcol=Math.max(maxcol,stone[1]);
        }
        int total=maxrow+1+maxcol+1;
        DSU ds=new DSU(total);
        HashSet<Integer> nodes = new HashSet<>();
        for(int []stone:stones){
            int r=stone[0];
            int c=stone[1]+maxrow+1;
            ds.union(r,c);
            nodes.add(r);
            nodes.add(c);
        }
        int cnt=0;
        for(int node:nodes){
            if(ds.find(node)==node) cnt++;
        }
        return stones.length-cnt;
    }
}