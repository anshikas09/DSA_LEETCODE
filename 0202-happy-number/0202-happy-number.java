class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set= new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            int sq=0;
            while(n>0){
                int d=n%10;
                sq+=d*d;
                n/=10;
            }
            n=sq;
        }
        return n==1;
    }
}