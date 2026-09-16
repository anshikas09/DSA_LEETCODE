class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        return subsetSum(nums,sum/2);
    }
    public boolean subsetSum(int []arr, int sum){
        int n = arr.length;
        boolean t[][]=new boolean [n+1][sum+1];
        for(int i=0;i<n+1;i++) t[i][0]=true;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(arr[i-1]<=j) t[i][j]=t[i-1][j] || t[i-1][j-arr[i-1]];
                else t[i][j]=t[i-1][j];
            }
        }
        return t[n][sum];
    }
}