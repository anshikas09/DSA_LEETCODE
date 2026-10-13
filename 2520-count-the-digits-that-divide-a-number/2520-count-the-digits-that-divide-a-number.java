class Solution {
    public int countDigits(int num) {
        int n=num;
        int sum=0;
        while(n>0){
            int d=n%10;
            if(d!=0 && num%d==0) sum++; 
            n/=10;
        }
        return sum;
    }
}