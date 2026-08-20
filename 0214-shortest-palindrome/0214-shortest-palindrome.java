class Solution {
    public String shortestPalindrome(String s) {
        String rev= new StringBuilder(s).reverse().toString();
        String combined=s+"$"+rev;
        int []lps=buildlps(combined);
        int longest=lps[combined.length()-1];
        String remaining= s.substring(longest);
        String add=new StringBuilder(remaining).reverse().toString();
        return add+s;
    }
    public int[] buildlps(String pattern){
        int m=pattern.length();
        int[]lps=new int[m];
        int len=0;
        int i=1;
        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0) len=lps[len-1];
                else{
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps;
    }
}