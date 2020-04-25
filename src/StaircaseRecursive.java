import java.util.HashMap;
import java.util.Map;

public class StaircaseRecursive {
    static Map<Integer,Integer> memoMap = new HashMap<>();
    public static void main(String args[]){
        int[] x = {1,3,5};
        System.out.println(numWays(6,x));
    }

    public static int numWays(int n, int[] x){
        if(memoMap.containsKey(n)){
            return memoMap.get(n);
        }
        if(n<0){
            return 0;
        }
        if(n<x[1]){
            return 1;
        }
        if(n==x[1]){
            return 2;
        }
        int numWays = numWays(n-1,x) + numWays(n-3,x) + numWays(n-5,x);
        memoMap.put(n,numWays);
        return numWays;
    }
}
