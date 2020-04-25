import java.util.*;

public class NthOrderStatistic {

    public static void main(String args[]){
        int[] arr = {1,4,3,5,8,2};
        System.out.print(NthOrderStatistic(arr, 6));
        Map<Integer,Integer> ma = new HashMap<>();
        ma.values().toArray();
    }

    public static int NthOrderStatistic(int[] arr, int n){
        int pivot = arr.length/2;
        int pivotNumber = arr[pivot];
        int temp = arr[arr.length-1];
        arr[arr.length-1] = arr[pivot];
        arr[pivot] = temp;
        int leftIndex=-1;
        int rightIndex=arr.length-1;
        while(true){
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>pivotNumber){
                    leftIndex = i;
                    break;
                }
            }
            for(int i=arr.length-2;i>=0;i--){
                if(arr[i]<pivotNumber){
                    rightIndex = i;
                    break;
                }
            }
            if(leftIndex == -1){
                leftIndex = arr.length-1;
                break;
            }
            if(rightIndex == arr.length-1){
                leftIndex = 0;
                break;
            }
            if(leftIndex < rightIndex){
                int tempo = arr[rightIndex];
                arr[rightIndex] = arr[leftIndex];
                arr[leftIndex] = tempo;
            }else{
                break;
            }
        }
        arr[arr.length-1] = arr[leftIndex];
        arr[leftIndex] = pivotNumber;
        if(n==leftIndex+1){
            return pivotNumber;
        }else if(n>leftIndex+1){
            return NthOrderStatistic(Arrays.copyOfRange(arr,leftIndex+1,arr.length),n-leftIndex-1);
        }else{
            return NthOrderStatistic(Arrays.copyOfRange(arr,0,leftIndex),n);
        }
    }
}
