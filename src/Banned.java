import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Banned {
    public static void main(String[] args) {
        String[] banned = {"bob","hit"};
        mostCommonWord("Bob. hIt, baLl",banned);
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> wordMap = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for(String ban : banned){
            bannedSet.add(ban);
        }
        String[] words = paragraph.replaceAll("[^a-zA-Z]"," ").toLowerCase().split(" ");
        for(String word : words){
            if(bannedSet.contains(word)){
                continue;
            }
            int count = 1;
            if(wordMap.containsKey(word)){
                count = wordMap.get(word);
                count++;
            }
            wordMap.put(word, count);
        }
        String result = "";
        for(String key : wordMap.keySet()){
            if(result.equals("") || wordMap.get(key) > wordMap.get(result)){
                result = key;
            }
        }
        return result;
    }
}
