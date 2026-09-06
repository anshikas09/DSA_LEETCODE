class Solution {
    static class Pair{
        int node;
        long dist;
        Pair(int node, long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time));
        }
        long dist[]=new long[n];
        long ways[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        pq.add(new Pair(0,0));
        int mod=1000000007;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            int node=curr.node;
            long d=curr.dist;
            if(d>dist[node]) continue;
            for(Pair next: adj.get(node)){
                int nextNode=next.node;
                long newDist=d+next.dist;
                if(newDist<dist[nextNode]){
                    dist[nextNode]=newDist;
                    ways[nextNode]=ways[node];
                    pq.add(new Pair(nextNode,newDist));
                }else if(newDist==dist[nextNode]) ways[nextNode]=(ways[nextNode]+ways[node])%mod;
            }
        }
        return (int)ways[n-1];
    }
}