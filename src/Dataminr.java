import java.util.HashMap;
import java.util.Map;

public class Dataminr {

    public static void main(String[] args) {
        Map<String,Integer> freqMap = new HashMap();
        freqMap.put("A123",4);
        freqMap.put("I12",2);
        Map<String,Integer> tempMap = new HashMap();
        for(Map.Entry<String,Integer> entry : freqMap.entrySet()){
            tempMap.put(entry.getKey(), entry.getValue());
        }
        while(!tempMap.isEmpty())
            for(Map.Entry<String,Integer> entry : freqMap.entrySet()){
               if(tempMap.get(entry.getKey()) != 0){
                   System.out.println(entry.getKey());
                   tempMap.put(entry.getKey(), entry.getValue()-1);
                   if(tempMap.get(entry.getKey()) == 0){
                       tempMap.remove(entry.getKey());
                   }
               }
            }
    }
}
