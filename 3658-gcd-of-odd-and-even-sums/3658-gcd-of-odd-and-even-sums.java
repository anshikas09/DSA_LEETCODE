class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumodd=0;
        int sumeven=0;
        for(int i=1;i<2*n;i+=2){
            sumodd+=i;
        }
        for(int i=2;i<=2*n;i+=2){
            sumeven+=i;
        }
        
        return gcd(sumodd,sumeven);
    }
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}