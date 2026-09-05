class Solution {
    static class Pair{
        int node, price,stops;
        Pair(int node, int price, int stops){
            this.node=node;
            this.price=price;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []flight:flights){
            int u=flight[0];
            int v=flight[1];
            int price=flight[2];
            adj.get(u).add(new Pair(v,price,0));
        }
        int[]dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(src,0,0));
        dist[src]=0;
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int node=curr.node;
            int price=curr.price;
            int stops=curr.stops;
            if(stops>k) continue;
            for(Pair next : adj.get(node)){
                int nextNode=next.node;
                int nextPrice=next.price;
                int newPrice=nextPrice+price;
                if(newPrice<dist[nextNode] && stops<=k){
                    dist[nextNode]=newPrice;
                    q.add(new Pair(nextNode,newPrice,stops+1));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
    }
}