import javafx.util.Pair;

import java.util.*;

public class CoinChange {
    static Map<Pair<Integer,Integer>,Long> memo = new HashMap<>();
    public static void main(String[] args) {
        int[] input = {1,2,5};
        coinChange(input, 11);
    }


    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                dp[i] = Math.min(1+dp[i-coins[j]],dp[i]);
            }
        }
        return dp[dp.length-1];
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
