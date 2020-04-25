public class CoinsChangeWays {
    public static void main(String[] args) {
        int[] input = {1,2,5};
        System.out.print(change(5,input));
    }

    public static int change(int amount, int[] coins) {
        return change(amount,coins,0);
    }

    public static int change(int amount, int[] coins, int index){
        int numWays = 0;
        if(amount == 0){
            return 1;
        }
        if(index == coins.length -1 && amount%coins[index]==0){
            return 1;
        }else if(index == coins.length -1){
            return -1;
        }
        int maxCoins = amount/coins[index];
        for(int i=0;i<=maxCoins;i++){
            int ways = change(amount-(i*coins[index]),coins,index+1);
            if(ways != -1){
                numWays += ways;
            }
        }
        return numWays;
    }
}
