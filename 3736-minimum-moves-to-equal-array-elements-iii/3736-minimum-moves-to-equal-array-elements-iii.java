class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++) max=Math.max(max,nums[i]);
        int cnt=0;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            cnt+=max-nums[i];
        }
        return cnt;
    }
}