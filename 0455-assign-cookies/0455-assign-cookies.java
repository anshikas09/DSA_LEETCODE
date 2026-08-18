class Solution {
    public int findContentChildren(int[] greed, int[] cookie) {
        Arrays.sort(greed);
        Arrays.sort(cookie);
        int child=0;
        int cook=0;
        int ans=0;
        while(cook<cookie.length && child<greed.length){
            if(cookie[cook]>=greed[child]){
                ans++;
                cook++;
                child++;
            }else cook++;
        }
        return ans;
    }
}