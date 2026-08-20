class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        int[]lps=buildlps(s);
        int longest=lps[n-1];
        int period=n-longest;
        return longest>0 && n%period==0;
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