
class Solution {
    public String smallestSubsequence(String s) {
        int fre[] = new int[26];
        boolean vis[] = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            fre[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            fre[ch - 'a']--;

            if (vis[ch - 'a']) continue;

            while (sb.length() > 0 &&
                   sb.charAt(sb.length() - 1) > ch &&
                   fre[sb.charAt(sb.length() - 1) - 'a'] > 0) {

                char last = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                vis[last - 'a'] = false;
            }

            sb.append(ch);
            vis[ch - 'a'] = true;
        }

        return sb.toString();
    }
}
