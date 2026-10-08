class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int lp=0;
        int rp=n-1;
        int max=0;
        while(lp<rp){
            int wt=rp-lp;
            int ht=Math.min(height[rp],height[lp]);
            int curr=ht*wt;
            max=Math.max(max,curr);
            if(height[rp]>height[lp]) lp++;
            else rp--;
        }
        return max;
    }
}