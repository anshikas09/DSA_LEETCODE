class Solution {
    int dp[][];
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        Arrays.sort(cuts);
        int arr[]=new int[m+2];
        arr[0]=0;
        arr[m+1]=n;
        for(int i=0;i<m;i++) arr[i+1]=cuts[i];
        dp=new int[m+2][m+2];
        for(int []r:dp) Arrays.fill(r,-1);
        return solve(1,m,arr);
    }
    public int solve(int i, int j , int[]cuts){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int left=solve(i,k-1,cuts);
            int right=solve(k+1,j,cuts);
            int cost = cuts[j+1]-cuts[i-1];
            min=Math.min(min,left+right+cost);
        }
        return dp[i][j]=min;
    }
}