import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<Set<String>> result = new HashSet<>();
        Set<String> sequence = new HashSet<>();
        ladderLength(beginWord, endWord, wordList, result, sequence);
        int minLength = 0;
        for(Set<String> elem : result){
            if(elem.size()<minLength){
                minLength = elem.size();
            }
        }
        return minLength;
    }

    public void ladderLength(String beginWord, String endWord, List<String> wordList, Set<Set<String>> result, Set<String> sequence){
        for(String word : wordList){
            if(!sequence.contains(word) && wordsDifferByOneChar(word, beginWord)){
                Set<String> newSequence = new HashSet<>();
                newSequence.addAll(sequence);
                newSequence.add(word);
                if(word.equals(endWord)){
                    result.add(newSequence);
                    return;
                }else{
                    ladderLength(word, endWord, wordList, result, newSequence);
                }
            }
        }
    }

    public boolean wordsDifferByOneChar(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }
        int count = 0;
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i) != word2.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
        new WordLadder().ladderLength("qa","sq",wordList);
    }
}
