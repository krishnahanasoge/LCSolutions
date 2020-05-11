public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        Integer numInt = new Integer(num);
        double numDouble = numInt.doubleValue();
        int start = 1;
        int end = num/2;
        int guess = start + (end-start)/2;
        while((double)(guess * guess) != numDouble){
            if(end - start <= 1){
                if(((double)guess+1)*((double)guess+1) == numDouble || ((double)guess-1)*((double)guess-1) == numDouble){
                    return true;
                }else{
                    return false;
                }
            }
            if(((double)guess * (double)guess) < numDouble){
                start = guess + 1;
                guess = start + (end-start)/2;
            }
            if(((double)guess * (double)guess) > numDouble){
                end = guess - 1;
                guess = start + (end-start)/2;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPerfectSquare(808201);
    }
}
