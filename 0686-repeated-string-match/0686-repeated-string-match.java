class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (kmpSearch(sb.toString(), b))
            return count;
        sb.append(a);
        count++;
        if (kmpSearch(sb.toString(), b))
            return count;
        return -1;
    }
    public boolean kmpSearch(String text, String pattern) {
        int[] lps = constructLPS(pattern);
        int i = 0; // text pointer
        int j = 0; // pattern pointer
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length())
                    return true;
            }
            else {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }
        return false;
    }
    public int[] constructLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}