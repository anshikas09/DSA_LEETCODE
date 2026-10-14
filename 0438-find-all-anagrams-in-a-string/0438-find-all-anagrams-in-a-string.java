class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int k=p.length();
        if(k>s.length()) return ans;
        int left=0;
        int freq[]=new int[26];
        for(char ch : p.toCharArray()){
            freq[ch-'a']++;
        }
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'a']--;
            if(right-left+1>k){
                freq[s.charAt(left)-'a']++;
                left++;
            }
            if(right-left+1==k){
                boolean match=true;
                for(int cnt:freq){
                    if(cnt!=0){
                        match = false;
                        break;
                    }
                }
                if(match) ans.add(left);
            }
        }
        return ans;
    }
}