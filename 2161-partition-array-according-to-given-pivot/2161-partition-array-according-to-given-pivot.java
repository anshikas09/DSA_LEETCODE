class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> s=new ArrayList<>();
        List<Integer> eq=new ArrayList<>();
        List<Integer> l=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<pivot) s.add(nums[i]);
            if(nums[i]==pivot) eq.add(nums[i]);
            if(nums[i]>pivot) l.add(nums[i]);
        }

        int ans[]=new int[n];
        int idx=0;
        for(int x : s) ans[idx++]=x;
        for(int x : eq) ans[idx++]=x;
        for(int x : l) ans[idx++]=x;
        return ans;
    }
}