class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int sum=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0) sum++;
            count+=mp.getOrDefault(sum-k,0);
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return count;
    }
}