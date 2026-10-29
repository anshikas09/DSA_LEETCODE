class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=square(slow);
            fast=square(square(fast));
        } while(slow!=fast);
        return slow==1;
    }
    private int square(int n){
        int sq=0;
        while(n>0){
            int d=n%10;
            sq+=d*d;
            n/=10;
        }
        return sq;
    }
}