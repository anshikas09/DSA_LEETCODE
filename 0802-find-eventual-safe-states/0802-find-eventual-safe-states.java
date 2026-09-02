class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<List<Integer>> rev= new ArrayList<>();
        for(int i=0;i<n;i++){
            rev.add(new ArrayList<>());
        }
        int indeg[]=new int[n];
        for(int i=0;i<n;i++){
            for(int it:graph[i]){
                rev.get(it).add(i);
                indeg[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int curr=q.remove();
            ans.add(curr);
            for(int it:rev.get(curr)){
                indeg[it]--;
                if(indeg[it]==0) q.add(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}