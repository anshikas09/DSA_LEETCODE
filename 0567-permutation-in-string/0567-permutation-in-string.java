class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k=s1.length();
        if(s1.length()>s2.length()) return false;
        int []freq=new int[26];
        for(char ch : s1.toCharArray()) freq[ch-'a']++;
        int left=0;
        for(int r=0;r<s2.length();r++){
            freq[s2.charAt(r)-'a']--;
            if(r-left+1>k){
                freq[s2.charAt(left)-'a']++;
                left++;
            }
            if(r-left+1==k){
                boolean match=true;
                for(int cnt:freq){
                    if(cnt!=0){
                        match=false;
                        break;
                    }
                }
                if(match) return true;
            }
        }
        return false;
    }

}