class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128];

        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        int cnt = 0;
        boolean odd = false;

        for(int i=0; i<128; i++) {

            if(freq[i] % 2 == 0) {
                cnt += freq[i];
            }
            else {
                cnt += freq[i] - 1;
                odd = true;
            }
        }

        if(odd) cnt++;

        return cnt;
    }
}