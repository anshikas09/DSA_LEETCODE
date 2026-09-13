class Solution {
    public String minWindow(String s, String t) {
        int l=0;
        int min=Integer.MAX_VALUE;
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++){
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }
        int start=0;
        int count=t.length();
        for(int r=0;r<s.length();r++){
            char rc= s.charAt(r);
            if(mp.containsKey(rc)){
                mp.put(rc,mp.get(rc)-1);
                if(mp.get(rc) >= 0){
                    count--;
                }
            }
            while(count==0){
                if(r-l+1<min){
                    min=r-l+1;
                    start=l;
                }
                char lc = s.charAt(l);
                if(mp.containsKey(lc)){
                    mp.put(lc,mp.get(lc)+1);
                    if(mp.get(lc) > 0){
                        count++;
                    }
                }
                l++;
            }
            
        }
        return min==Integer.MAX_VALUE? "" : s.substring(start,start+min);
    }
}