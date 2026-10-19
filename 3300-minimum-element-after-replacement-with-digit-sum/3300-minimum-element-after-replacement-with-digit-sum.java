class Solution {
    public int sumofdigits(int n){
        int sum=0;
        while(n>0){
            int d=n%10;
            sum+=d;
            n/=10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int[] arr= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=sumofdigits(nums[i]);
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            // System.out.print(arr[i]+" ");
            if(arr[i]<min) min=arr[i];
        }
        
        return min;
    }
}