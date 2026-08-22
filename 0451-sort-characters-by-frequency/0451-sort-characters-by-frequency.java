class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> mp =new HashMap<>();
        for(char c: s.toCharArray()){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        ArrayList<Character> chars= new ArrayList<>(mp.keySet());
        chars.sort((a,b)->mp.get(b)-mp.get(a));
        StringBuilder sb=new StringBuilder();
        for(char c:chars){
            for(int i=0;i<mp.get(c);i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}