class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(0,candidates,target, new ArrayList<>());
        return ans;
    }
    private void solve(int idx, int[]nums, int k, List<Integer> temp){
        if(k<0) return ;
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            if(nums[i]>k) break;
            temp.add(nums[i]);
            solve(i+1,nums,k-nums[i],temp);
            temp.remove(temp.size()-1);
        }
    }
}