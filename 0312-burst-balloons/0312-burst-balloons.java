class Solution {
    int dp[][]=new int [305][305];
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        for(int i=0;i<n+2;i++){
            for(int j=0;j<n+2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(1,n,arr);
    }
    public int solve(int i, int j, int[]arr){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max=0;
        for(int k=i;k<=j;k++){
            int left=solve(i,k-1,arr);
            int right=solve(k+1,j,arr);
            int cost = arr[i-1]*arr[k]*arr[j+1];
            max=Math.max(max,left+right+cost);
        }
        return dp[i][j]=max;
    }
}