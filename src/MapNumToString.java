import java.util.HashMap;
import java.util.Map;

public class MapNumToString {
    static Map<String,Integer> memoMap = new HashMap<>();

    public static void main(String args[]){
        Map<String,String> numMap = new HashMap<>();
        numMap.put("a","1");
        numMap.put("b","2");
        numMap.put("c","3");
        numMap.put("d","4");
        numMap.put("e","5");
        numMap.put("f","6");
        numMap.put("g","7");
        numMap.put("h","8");
        numMap.put("i","9");
        numMap.put("j","10");
        numMap.put("k","11");
        numMap.put("l","12");
        numMap.put("m","13");
        numMap.put("n","14");
        numMap.put("o","15");
        numMap.put("p","16");
        numMap.put("q","17");
        numMap.put("r","18");
        numMap.put("s","19");
        numMap.put("t","20");
        numMap.put("u","21");
        numMap.put("v","22");
        numMap.put("w","23");
        numMap.put("x","24");
        numMap.put("y","25");
        numMap.put("z","26");
        //bfbf,bfz,zbf,zz
        System.out.println(numWays("262626",numMap));
    }

    public static int numWays(String input, Map<String,String> numMap){
        int numWays;
        if(memoMap.containsKey(input)){
            return memoMap.get(input);
        }
        if(input.charAt(0)=='0'){
            return 0;
        }
        if(input.length() == 0 || input.length() == 1){
            return input.length();
        }
        if(input.length() == 2 && Integer.parseInt(input) <= 26){
            return 2;
        }
        if(Integer.parseInt(input.substring(0,2)) <= 26){
            numWays =  numWays(input.substring(1),numMap) + numWays(input.substring(2),numMap);
        }else{
            numWays =  numWays(input.substring(1),numMap);
        }
        memoMap.put(input,numWays);
        return numWays;
    }
}
