class Solution {
    public boolean checkDivisibility(int n) {
        int sum=sumOfDigits(n);
        int pro=proOfDigits(n);
        int s=sum+pro;
        if(n%s==0) return true;
        return false;
    }
    public int sumOfDigits(int n){
        if(n==0) return 0;
        return (n%10)+sumOfDigits(n/10);
    }
    public int proOfDigits(int n){
        if(n==0) return 1;
        return (n%10)*proOfDigits(n/10);
    }
}