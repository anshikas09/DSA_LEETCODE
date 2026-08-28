class Solution {
    static final int MOD = 1000000007;
    long dp[][];
    public int numMusicPlaylists(int n, int l, int k) {
        dp=new long[l+1][n+1];
        for(long[]r:dp) java.util.Arrays.fill(r,-1);
        return solve(0,0,n,l,k);
    }
    private int solve(int i, int j, int n, int l, int k){
        if(i==l) return j==n?1:0;
        if(dp[i][j]!=-1) return (int)dp[i][j];
        long ans=0;
        if(j<n){
            int newSongs=n-j;
            ans+=(long)newSongs*solve(i+1,j+1,n,l,k);
            ans%=MOD;
        }
        if(j>k){
            int oldSongs=j-k;
            ans+=(long)oldSongs*solve(i+1,j,n,l,k);
            ans%=MOD;
        }
        dp[i][j]=ans;
        return (int)ans;
    }
}