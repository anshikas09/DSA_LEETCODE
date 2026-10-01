class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(0,candidates,target,new ArrayList<>());
        return ans;
    }
    public void solve(int idx, int[]nums, int target, List<Integer> temp){
        if(target<0) return;
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            solve(i,nums,target-nums[i],temp);
            temp.remove(temp.size()-1);
        }
    }
}