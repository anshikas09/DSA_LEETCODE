class Solution {
    public String frequencySort(String s) {
        int freq[]=new int [256];
        StringBuilder sb= new StringBuilder();
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        for (int k = 0; k < 256; k++) {
            int maxFreq = 0;
            int maxChar = 0;
            for (int i = 0; i < 256; i++) {
                if (freq[i] > maxFreq) {
                    maxFreq = freq[i];
                    maxChar = i;
                }
            }
            if (maxFreq == 0) {
                break;
            }
            for (int j = 0; j < maxFreq; j++) {
                sb.append((char) maxChar);
            }
            freq[maxChar] = 0;
        }
        return sb.toString();
    }
}