class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int st=0;
        int end=n-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            int miss=arr[mid]-(mid+1);
            if(miss<k) st=mid+1;
            else end=mid-1;
        }
        return st+k;
    }
}