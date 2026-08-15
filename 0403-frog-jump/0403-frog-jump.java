class Solution {
    int dp[][];
    HashMap <Integer,Integer> mp = new HashMap<>();
    public boolean canCross(int[] stones) {
        int n=stones.length;
        if(stones[1]-stones[0]!=1) return false;
        for(int i=0;i<n;i++) mp.put(stones[i],i);
        dp=new int[n][n];
        for(int []r:dp) Arrays.fill(r,-1);
        return solve(1,1,stones);
    }
    public boolean solve(int i, int k, int[]stones){
        if(i==stones.length-1) return true;
        if(dp[i][k]!=-1) return dp[i][k]==1;
        boolean k0=false, k1=false, k2=false;
        if(mp.containsKey(stones[i]+k)) k0=solve(mp.get(stones[i]+k),k,stones);
        if(k>1 && mp.containsKey(stones[i]+k-1)) k1=solve(mp.get(stones[i]+k-1),k-1,stones);
        if(mp.containsKey(stones[i]+k+1)) k2=solve(mp.get(stones[i]+k+1),k+1,stones);
        dp[i][k]=(k0||k1||k2) ? 1: 0;
        return dp[i][k]==1;
    }
}