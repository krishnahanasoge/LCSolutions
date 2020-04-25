public class HappyNumber {
    public static void main(String args[]){
        isHappy(2);
    }

    public static boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        int newNumber = 0;
        while(n!=0){
            newNumber+=Math.pow(n%10,2);
            n = n/10;
        }
        return isHappy(newNumber);
    }
}
