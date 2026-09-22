class Solution {
    int [][]dp;
    public int superEggDrop(int k, int n) {
        dp=new int[k+1][n+1];
        for(int []r:dp) Arrays.fill(r,-1);
        return solve(k,n);
    }
    public int solve(int i, int j){    //i-> eggs j->floors
        if(j==0||j==1) return j;
        if(i==1) return j;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        int low=1;
        int high=j;

        while(low<=high){
            int mid=low+(high-low)/2;
            int breaks=solve(i-1,mid-1);
            int notBreaks=solve(i,j-mid);
            int worstCase=1+Math.max(breaks,notBreaks);
            ans=Math.min(ans,worstCase);
            if(breaks>notBreaks) high=mid-1;
            else low=mid+1;
        }
        return dp[i][j]=ans;
    }
}