class Solution {
    private List<Integer> digits(int n){
        List<Integer> ans = new ArrayList<>();
        while(n>0){
            int d=n%10;
            ans.add(d);
            n/=10;
        }
        return ans;
    }
    public int maxProduct(int n) {
        List<Integer> digit = digits(n);
        int a=0, b=0;
        for(int num:digit){
            if(num>=a){
                b=a;
                a=num;
            }else if(num>b) b=num;
        }
        return a*b;
    }
}