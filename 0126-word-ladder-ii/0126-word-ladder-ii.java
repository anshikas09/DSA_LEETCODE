class Solution {
    String b;
    HashMap<String,Integer> mp;
    List<List<String>> ans;
    private void dfs(String word, List<String>seq){
        if(word.equals(b)){
            //since java works with referenceee, so create a duplicate and store reverse of it 
            List<String> dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps=mp.get(word);
        int sz=word.length();
        for(int i=0;i<sz;i++){
            for(char ch='a';ch<='z';ch++){
                char replacedChar[]=word.toCharArray();
                replacedChar[i]=ch;
                String replacedWord=new String(replacedChar);
                if(mp.containsKey(replacedWord) && mp.get(replacedWord)+1==steps){
                    seq.add(replacedWord);
                    dfs(replacedWord,seq);
                    seq.remove(seq.size()-1);
                } 
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set= new HashSet<>();
        int len=wordList.size();
        for(int i=0;i<len;i++) set.add(wordList.get(i));
        Queue<String>q=new LinkedList<>();
        b=beginWord;
        q.add(beginWord);
        mp=new HashMap<>();
        mp.put(beginWord,1);
        int sizee=beginWord.length();
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek();
            int steps=mp.get(word);
            q.remove();
            if(word.equals(endWord)) break;
            for(int i=0;i<sizee;i++){
                for(char ch='a';ch<='z';ch++){
                char replacedChar[]=word.toCharArray();
                replacedChar[i]=ch;
                String replacedWord=new String(replacedChar);
                if(set.contains(replacedWord)){
                    q.add(replacedWord);
                    set.remove(replacedWord);
                    mp.put(replacedWord,steps+1);
                }
            }
        }
        }
        ans=new ArrayList<>();
        if(mp.containsKey(endWord)){
            List<String> seq= new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }
}