class Solution {
    public int findMaxLength(int[] nums) {
        int max=0;
        int sum=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]==0) ? -1 :1;
            if(mp.containsKey(sum)) max=Math.max(max,i-mp.get(sum));
            if(!mp.containsKey(sum)) mp.put(sum,i);
        }
        return max;
    }
}