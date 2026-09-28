class Solution {
    public void swap(int[]nums, int l,int r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
        }
    public void reverse(int nums[],int n, int st, int end){
        while(st<end){
            swap(nums,st,end);
            st++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(nums,n,0,n-1);
        reverse(nums,n,0,k-1);
        reverse(nums,n,k,n-1);   
    }
}