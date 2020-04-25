import java.util.*;

public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long,List<Long>> arrMap = new HashMap<Long,List<Long>>();
        arrMap.put(1237L,new ArrayList<>());
        for(long i = 0;i<100000;i++){
            arrMap.get(1237L).add(i);
        }
        long tripletCount = 0;
        for(Long key : arrMap.keySet()){
            if(r == 1 && arrMap.get(key).size() >= 3){
                long keySize = arrMap.get(key).size();
                tripletCount+=(keySize*(keySize-1)*(keySize-2)/6);
            }else if(r == -1 && arrMap.get(key).size() >= 2 && arrMap.containsKey(key*r)){
                long keySize = arrMap.get(key).size();
                tripletCount+=(keySize*(keySize-1)*arrMap.get(key*r).size()/2);
            }else if(arrMap.containsKey(key*r) && arrMap.containsKey(key*r*r)){
                long keySize = arrMap.get(key).size();
                long rKeySize = arrMap.get(key*r).size();
                long rrKeySize = arrMap.get(key*r*r).size();
                tripletCount+=(keySize*rKeySize*rrKeySize);
            }
        }
        return tripletCount;
    }

    public static void main(String args[]){
        List<Long> arr = new ArrayList<Long>();
        countTriplets(arr,1);
    }
}
