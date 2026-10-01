class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        solve(0,nums,new ArrayList<>());
        return ans;
    }
    public void solve(int idx, int []nums, List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            solve(i+1,nums,temp);
            temp.remove(temp.size()-1);
        }
    }
}