class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
    }
    public int atmost(int[]nums,int k){
        int l=0;
        int count=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int r=0;r<nums.length;r++){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while(mp.size()>k){
                mp.put(nums[l],mp.get(nums[l])-1);
                if(mp.get(nums[l])==0) mp.remove(nums[l]);
                l++;
            }
            count+=r-l+1;
        }
        return count;
    }
}