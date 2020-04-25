import javafx.util.Pair;

import java.util.*;

public class CoinChange {
    static Map<Pair<Integer,Integer>,Long> memo = new HashMap<>();
    public static void main(String[] args) {
        int[] input = {186,419,83,408};
        coinChange(input, 6249);
    }


    public static int coinChange(int[] coins, int amount) {
        List<Integer> coinsList = new ArrayList<>();
        for(int i : coins){
            coinsList.add(i);
        }
        Collections.sort(coinsList);
        long result = coinChange(coinsList, amount, coinsList.size()-1);
        if(result != Integer.MAX_VALUE){
            return ((Long)result).intValue();
        }else{
            return -1;
        }
    }

    public static long coinChange(List<Integer> coins, long amount, int fromIndex) {
        if(amount == 0){
            return 0;
        }
        Pair<Integer, Integer> pair = new Pair(amount, fromIndex);
        if(memo.containsKey(pair)){
            return memo.get(pair);
        }
        long maxCoinsWithCurrentCoin = amount/coins.get(fromIndex);
        long minTotalCoinsWithCurrentCoin = Integer.MAX_VALUE;
        if(amount % coins.get(fromIndex) != 0 && fromIndex == 0){
            memo.put(pair,minTotalCoinsWithCurrentCoin);
            return minTotalCoinsWithCurrentCoin;
        }else if(fromIndex == 0){
            memo.put(pair,maxCoinsWithCurrentCoin);
            return maxCoinsWithCurrentCoin;
        }
        for(long i=maxCoinsWithCurrentCoin;i>=0;i--){
            minTotalCoinsWithCurrentCoin = Math.min(minTotalCoinsWithCurrentCoin,i+coinChange(coins, amount-i*coins.get(fromIndex), fromIndex-1));
        }
        memo.put(pair,minTotalCoinsWithCurrentCoin);
        return minTotalCoinsWithCurrentCoin;

    }
}
