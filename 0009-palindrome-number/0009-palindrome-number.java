class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int rev=0;
        int n=x;
        while(x!=0){
            int d=x%10;
            if(rev>Integer.MAX_VALUE/10 || rev<Integer.MIN_VALUE/10)
            return false;
            rev=rev*10+d;
            x/=10;
        }
        if(rev==n){
            return true;
        }
        else{
            return false;
        }
    }
}