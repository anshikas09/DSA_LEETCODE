class Solution {
    public int maxRepeating(String sequence, String word) {
        int count=0;
        String curr=word;
        while(strStr(sequence,curr)){
            count++;
            curr+=word;
        }
        return count;
    }
    public boolean strStr(String text, String pattern) {
        int n=text.length();
        int m=pattern.length();
        int[]lps=buildlps(pattern);
        int i=0, j=0;
        while(i<n){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
                if(j==m) return true;
            }else{
                if(j==0) i++;
                else j=lps[j-1];
            }
        }
        return false;
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