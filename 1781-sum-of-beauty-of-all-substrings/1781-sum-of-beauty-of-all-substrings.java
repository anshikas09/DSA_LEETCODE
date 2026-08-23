class Solution {
    public int beautySum(String s) {
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            HashMap<Character,Integer> mp = new HashMap<>();
            for(int j=i;j<n;j++){
                char ch = s.charAt(j);
                mp.put(ch,mp.getOrDefault(ch,0)+1);
                ans+=solve(mp);
            }
        }
        return ans;
    }
    public int solve(HashMap<Character, Integer> mp){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int freq:mp.values()){
            if(freq>max) max=freq;
            if(freq<min) min=freq;
        }
        return max-min;
    }
}