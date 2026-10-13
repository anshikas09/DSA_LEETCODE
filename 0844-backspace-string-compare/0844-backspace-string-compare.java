class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='#' && sb1.length()>0) sb1.deleteCharAt(sb1.length()-1);
            else if(ch!='#') sb1.append(ch);
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(ch=='#' && sb2.length()>0) sb2.deleteCharAt(sb2.length()-1);
            else if(ch!='#') sb2.append(ch);
        }
        return sb1.toString().equals(sb2.toString());
    }
}