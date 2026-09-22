class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int st=0;
        int end=0;
        long sum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            sum+=piles[i];
            end=Math.max(end,piles[i]);
        }
        st =(int) Math.max(1, sum / h);
        while(st<=end){
            int mid=st+(end-st)/2;
            int total=0, count=0;
            for(int i=0;i<n;i++){
                total+=piles[i]/mid;
                if(piles[i]%mid!=0) total++;
            }if(total>h){
                st=mid+1;
            }else {
                ans=mid;
                end=mid-1;
            }
        }
        return ans;
    }
}