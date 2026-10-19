class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> small= new ArrayList<>();
        List<Integer> large= new ArrayList<>();
        List<Integer> equal= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot) small.add(nums[i]);
            if(nums[i]==pivot) equal.add(nums[i]);
            if(nums[i]>pivot) large.add(nums[i]);
        }
        int ans[]=new int[nums.length];
        int idx=0;
        for(int num:small) ans[idx++]=num;
        for(int num:equal) ans[idx++]=num;
        for(int num:large) ans[idx++]=num;
        return ans;
    }
}