import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet();
        for(String word: wordDict){
            wordSet.add(word);
        }
        return wordBreak(s, wordSet);
    }

    public boolean wordBreak(String s, Set<String> wordSet) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            if(wordSet.contains(sb.toString())){
                if(wordBreak(s.substring(i+1), wordSet)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordList = Arrays.asList("leet","code");
        wordBreak.wordBreak("leetcode",wordList);
    }
}
