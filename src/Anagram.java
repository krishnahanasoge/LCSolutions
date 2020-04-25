import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length() || s.length() == 0){
            return false;
        }
        Map<Character,Integer> charMap = new HashMap<>();
        for(int i=0; i<s.length();i++){
            if(charMap.containsKey(s.charAt(i))){
                int count = charMap.get(s.charAt(i));
                count++;
                charMap.put(s.charAt(i),count);
            }else{
                charMap.put(s.charAt(i),1);
            }
            if(charMap.containsKey(t.charAt(i))){
                int count = charMap.get(s.charAt(i));
                count--;
                charMap.put(s.charAt(i),count);
            }else{
                charMap.put(s.charAt(i),-1);
            }
        }
        for(int value : charMap.values()){
            if(value != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        isAnagram("anagram","nagaram");
    }
}
