class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        int p=1;
        while(i<nums.length){
            if(nums[i]!=nums[i-1]) nums[p++]=nums[i++];
            else i++;
        }
        return p;
    }
}