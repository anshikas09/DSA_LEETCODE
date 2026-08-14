class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int prev = idx - 1; prev >= -1; prev--) {
                int len1 = next[prev + 1];
                int len2 = 0;
                if (prev == -1 || nums[idx] > nums[prev]) {
                    len2 = 1 + next[idx + 1];
                }
                curr[prev + 1] = Math.max(len1, len2);
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }
        return next[0];
    }
}