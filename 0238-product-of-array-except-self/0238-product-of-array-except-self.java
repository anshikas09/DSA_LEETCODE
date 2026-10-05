class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int p1[]=new int[n];
        p1[0]=nums[0];
        int p2[]=new int[n];
        p2[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            p1[i]=nums[i]*p1[i-1];
        }
        for(int i=n-2;i>=0;i--){
            p2[i]=nums[i]*p2[i+1];
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if (i == 0) {
                ans[i] = p2[i + 1];
            }
            else if (i == n - 1) {
                ans[i] = p1[i - 1];
            }
            else {
                ans[i] = p1[i - 1] * p2[i + 1];
            }
        }
        return ans;
    }
}