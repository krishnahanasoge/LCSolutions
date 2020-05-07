public class ReverseInt {

    public static int reverse(int x) {
        Long num = 0L;
        while(x!=0){
            int remainder = x%10;
            num = num*10 + remainder;
            x = x/10;
        }
        if(num > (long)Integer.MAX_VALUE){
            return 0;
        }else{
            return num.intValue();
        }
    }

    public static void main(String[] args) {
        reverse(123);
    }
}
