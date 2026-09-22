class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int st=0;
        int end=0;
        for(int i=0;i<n;i++){
            st=Math.max(st,weights[i]);
            end+=weights[i];
        }
        int ans=0;
        while(st<=end){
            int mid=st+(end-st)/2;
            int ships=0,count=1;
            for(int i=0;i<n;i++){
                ships+=weights[i];
                if(ships>mid){
                    count++;
                    ships=weights[i];
                }
            }
            if(count<=days){
                ans=mid;
                end=mid-1;
            }else st=mid+1;
        }
        return ans;
    }
}