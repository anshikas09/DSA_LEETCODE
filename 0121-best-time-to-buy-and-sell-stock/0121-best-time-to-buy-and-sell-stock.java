class Solution {
    public int maxProfit(int[] arr) {
        int pro=0;
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            int cost=arr[i]-min;
            pro=Math.max(pro,cost);
            min=Math.min(min,arr[i]);
        }
        return pro;
    }
}