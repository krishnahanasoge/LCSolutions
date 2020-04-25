import java.util.ArrayList;
import java.util.List;

public class PrimeCount {
    public static void main(String[] args) {
        countPrimes(10);
    }

    public static int countPrimes(int n) {
        int primeCount = 1;//2
        List<Integer> primeNumbers = new ArrayList<>();//2,3
        primeNumbers.add(2);
        if(n<3){
            return 0;
        }
        if(n == 3){
            return 1;
        }
        for(int i=3;i<n;i++){
            boolean isPrime = true;
            for(int j=0;j<primeNumbers.size();j++){
                int primeNumber = primeNumbers.get(j);
                if(i%primeNumber == 0){
                    isPrime = false;
                    break;
                }
                if(primeNumber > Math.sqrt(i)){
                    break;
                }
            }
            if(isPrime){
                primeNumbers.add(i);
                primeCount++;
            }
        }
        return primeCount;
    }
}
