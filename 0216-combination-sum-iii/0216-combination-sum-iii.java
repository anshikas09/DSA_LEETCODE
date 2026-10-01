class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        solve(1,n,k,new ArrayList<>());
        return ans;
    }
    private void solve(int idx, int n, int k, List<Integer>temp){
        if(n==0 && k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<=9;i++){
            if(i>n || k<=0) break;
            temp.add(i);
            solve(i+1,n-i,k-1,temp);
            temp.remove(temp.size()-1);
        }
    }
}