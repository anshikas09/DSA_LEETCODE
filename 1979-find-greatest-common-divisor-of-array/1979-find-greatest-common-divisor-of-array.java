class Solution {
    public int findGCD(int[] nums) {
        int a=0;
        int b=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            a=Math.max(nums[i],a);
            b=Math.min(nums[i],b);
        }
        return gcd(a,b);
    }
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}