class Solution {
    public boolean isPalindrome(String s) {
        String st= s.replaceAll("[^0-9A-Za-z]","").toLowerCase();
        int l=0;
        int r=st.length()-1;
        while(l<=r){
            if(st.charAt(l)!=st.charAt(r)) return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }
}