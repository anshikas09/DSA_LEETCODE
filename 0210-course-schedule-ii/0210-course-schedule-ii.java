class Solution {
    public int[] findOrder(int V, int[][] prereq) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int m=prereq.length;
        for(int i=0;i<m;i++){
            adj.get(prereq[i][1]).add(prereq[i][0]);
        }
        int indeg[]=new int[V];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)) indeg[it]++;
        }
        for(int i=0;i<V;i++){
            if(indeg[i]==0) q.add(i);
        }
        int[]ans=new int[V];
        int i=0;
        while(!q.isEmpty()){
            int node=q.remove();
            ans[i++]=node;
        for(int it:adj.get(node)){
            indeg[it]--;
            if(indeg[it]==0) q.add(it);
        }
        }
        if(i==V) return ans;
        return new int[]{};
    }
}