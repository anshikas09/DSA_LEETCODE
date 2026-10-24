class Solution {
    public boolean rotateString(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }
    String temp = str1 + str1;
    if (temp.contains(str2)) {
      return true;
    }
    return false;
    }
}