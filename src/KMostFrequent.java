import java.util.*;

public class KMostFrequent {

    public static void main(String args[]){
        int[] input = {1,1,1,2,2,3};
        topKFrequent(input,2);
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> numsMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int frequency = 1;
            if(numsMap.containsKey(nums[i])){
                frequency = numsMap.get(nums[i]);
                frequency++;
            }
            numsMap.put(nums[i], frequency);
        }
        Object[] objs = numsMap.values().toArray();
        int[] input = new int[numsMap.size()];
        for(int i=0;i<numsMap.size();i++){
            input[i] = (Integer)objs[i];
        }
        int kthLargest = NthOrderStatistic(input,numsMap.size()+1-k);
        for(int key : numsMap.keySet()){
            if(numsMap.get(key)>=kthLargest){
                result.add(key);
            }
        }
        return result;
    }

    public static int NthOrderStatistic(int[] arr, int n){
        if(arr.length==0){
            return 0;
        }
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
