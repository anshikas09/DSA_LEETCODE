class Solution {
    HashMap<String,Boolean> mp =new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n!=m) return false;
        if(s1.equals(s2)) return true;
        String key=s1+"#"+s2;
        if(mp.containsKey(key)) return mp.get(key);
        boolean flag=false;
        for(int i=1;i<n;i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i,n),s2.substring(i,n))){
                flag=true;
                break;
            }
            if(isScramble(s1.substring(0,i),s2.substring(n-i,n)) && isScramble(s1.substring(i,n),s2.substring(0,n-i))){
                flag=true;
                break;
            }
        }
        mp.put(key,flag);
        return flag;
    }
}