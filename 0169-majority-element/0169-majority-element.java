class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int count=0;
        int ele=nums[0];
        for(int i=0;i<n;i++){
            if(count ==0) {
                ele=nums[i];
                count++;
            }else if(nums[i]==ele) count++;
            else count--;
        }
        int c1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele) c1++;
        }
        if(c1>n/2) return ele;
        else return -1;
    }
}