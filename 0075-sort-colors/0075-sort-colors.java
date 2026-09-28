class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int st=0;
        int end=n-1;
        int mid=0;
        while(mid<=end){
            if(nums[mid]==0){
                swap(nums,st,mid);
                st++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else {
                swap(nums,mid,end);
                end--;
            }
        }
    }
    public void swap(int[]arr, int st, int end){
        int temp=arr[st];
        arr[st]=arr[end];
        arr[end]=temp;
    }
}