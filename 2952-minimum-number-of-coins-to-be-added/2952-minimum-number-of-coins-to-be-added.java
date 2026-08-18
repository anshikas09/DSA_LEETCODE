class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        long reach=0;
        int ans=0;
        int i=0;
        Arrays.sort(coins);
        while(reach<target){
            if(i<coins.length && coins[i]<=reach+1){
                reach+=coins[i];
                i++;
            }else{
                reach+=reach+1;
                ans++;
            }
        }
        return ans;
    }
}