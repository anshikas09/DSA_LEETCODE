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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DSU ds =new DSU(n);
        HashMap<String, Integer> mp =new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mp.containsKey(mail)) mp.put(mail,i);
                else ds.union(i,mp.get(mail));
            }
        }
        ArrayList<String>[] merged = new ArrayList[n];
        for(int i=0;i<n;i++){
            merged[i]=new ArrayList<>();
        }
        for(Map.Entry<String,Integer> it: mp.entrySet()){
            String mail=it.getKey();
            int root=ds.find(it.getValue());
            merged[root].add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(merged[i].size()==0) continue;
            Collections.sort(merged[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it: merged[i]) temp.add(it);
            ans.add(temp);
        }
        return ans;
    }
}