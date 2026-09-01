class Solution {
    public boolean canFinish(int V, int[][] prereq) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int m=prereq.length;
        for(int i=0;i<m;i++){
            adj.get(prereq[i][0]).add(prereq[i][1]);
        }
        int indeg[]=new int[V];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)) indeg[it]++;
        }
        for(int i=0;i<V;i++){
            if(indeg[i]==0) q.add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            ans.add(node);
        for(int it:adj.get(node)){
            indeg[it]--;
            if(indeg[it]==0) q.add(it);
        }
        }
        if(ans.size()==V) return true;
        return false;
    }
}