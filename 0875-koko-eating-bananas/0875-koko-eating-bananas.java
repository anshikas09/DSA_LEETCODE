class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long st=1;
        long end=0;
        for(int i=0;i<piles.length;i++){
            end=Math.max(end,piles[i]);
        }
        long ans=end;
        while(st<=end){
            long mid= st+(end-st)/2;
            long total=0;
            for(int i=0;i<piles.length;i++){
                total += (piles[i]+ mid - 1) / mid;
            }
            if(total>h) st=mid+1;
            else{
                ans=mid;
                end=mid-1;
            }
        }
        return (int)ans;
    }
}