class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int minidx=0,maxidx=0;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[minidx]) minidx=i;
            if(nums[i]>nums[maxidx]) maxidx=i;
        }
        int left=Math.min(minidx,maxidx);
        int right=Math.max(minidx,maxidx);
        int front=right+1;
        int back=n-left;
        int frontback=(left+1)+(n-right);
        return Math.min(front,Math.min(back,frontback));
    }
}