class Solution {
    public int totalFruit(int[] fruits) {
            int n=fruits.length;
            int l=0;
            int maxlen=0;
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int r=0;r<n;r++){
                if(mp.containsKey(fruits[r])) mp.put(fruits[r],mp.get(fruits[r])+1);
                else mp.put(fruits[r],1);

                while(mp.size()>2){
                    int freq=mp.get(fruits[l]);
                    if(freq==1) mp.remove(fruits[l]);
                    else mp.put(fruits[l],freq-1);
                    l++;
                }
                maxlen=Math.max(maxlen,r-l+1);
            }
        return maxlen;
    }
}