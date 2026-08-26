class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        int ones=0,l=0;
        String res="";
        for(int r=0;r<n;r++){
            if(s.charAt(r)=='1') ones++;
            while(ones>k){
                if(s.charAt(l)=='1') ones--;
                l++;
            }
            if(ones==k){
                while(s.charAt(l)=='0') l++;
                String cand=s.substring(l,r+1);
                if(res.isEmpty() || cand.length()<res.length() || (cand.length()==res.length() && cand.compareTo(res)<0)) res=cand;
            }
        }
        return res;
    }
}