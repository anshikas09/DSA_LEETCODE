class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        List<Integer> ans= new ArrayList<>();
        if(m>n) return ans;
        int pfreq[]=new int [26];
        int wind[]=new int[26];
        for(int i=0;i<m;i++){
            pfreq[p.charAt(i)-'a']++;
            wind[s.charAt(i)-'a']++;
        }

        for(int i=0;i<=n-m;i++){
            if(Arrays.equals(pfreq,wind)) ans.add(i);
            if(i<n-m){
                wind[s.charAt(i)-'a']--;
                wind[s.charAt(i+m)-'a']++;
            }
        }
        return ans;
    }
}