class Solution {
    int dp[][];
    public boolean checkValidString(String s) {
        int n=s.length();
        dp=new int[n][n+1];
        for(int []r:dp) Arrays.fill(r,-1);
        return solve(s,0,0);
    }
    public boolean solve(String s, int idx, int cnt){
        int n=s.length();
        if(cnt<0) return false;
        if(idx==n) {
            return (cnt==0);
        }
        boolean isValid=false;
        char ch =s.charAt(idx);
        if(dp[idx][cnt]!=-1) return dp[idx][cnt]==1;
        if(ch=='(') isValid=solve(s,idx+1,cnt+1);
        else if(ch==')') isValid=solve(s,idx+1,cnt-1);
        else isValid= solve(s,idx+1,cnt+1) || solve(s,idx+1,cnt-1) || solve(s,idx+1,cnt);
        dp[idx][cnt]=isValid ? 1:0;
        return isValid;
    }
}