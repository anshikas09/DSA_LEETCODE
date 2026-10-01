class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,nums,new ArrayList<>(),ans);
        return ans;
    }
    public void solve(int idx, int []nums,List<Integer>temp, List<List<Integer>>ans){
        ans.add(new ArrayList<>(temp));
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            solve(i+1,nums,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}
