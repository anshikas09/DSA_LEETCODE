class Solution {
    public int largestAltitude(int[] gain) {
        int alt=0;
        int mx=0;
        for(int i=0;i<gain.length;i++){
            alt+=gain[i];
            mx=Math.max(mx,alt);
        }
        return mx;
    }
}