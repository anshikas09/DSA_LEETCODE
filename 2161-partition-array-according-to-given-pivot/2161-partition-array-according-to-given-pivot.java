class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> small= new ArrayList<>();
        List<Integer> equal= new ArrayList<>();
        List<Integer> large= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot) small.add(nums[i]);
            else if(nums[i]==pivot) equal.add(nums[i]);
            else if(nums[i]>pivot) large.add(nums[i]);
        }
        int ans[]=new int[nums.length];
        int idx=0;
        for(int x : small) ans[idx++]=x;
        for(int x : equal) ans[idx++]=x;
        for(int x : large) ans[idx++]=x;

        return ans;
    }
}