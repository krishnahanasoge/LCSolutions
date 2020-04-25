public class KthLargest {

    public static int findKthLargest(int[] nums, int k) {
        int posFind = nums.length-k;
        return findNthOrder(nums, posFind, 0, nums.length -1);
    }

    public static int findNthOrder(int[] nums, int n, int start, int end){
        if(start == end){
            return nums[start];
        }
        int pivot = nums[end];
        int first = start;
        int second = end-1;
        while(first<second){
            while(nums[first]<pivot){
                first++;
            }
            while(nums[second]>pivot){
                second--;
            }
            if(first<second){
                int temp = nums[second];
                nums[second] = nums[first];
                nums[first] = temp;
                first++;
                second--;
            }
        }
        int pivotIndex = first;
        if(pivotIndex == n){
            return pivot;
        }
        int temp = nums[first];
        nums[first] = nums[end];
        nums[end] = temp;
        if(pivotIndex > n){
            return findNthOrder(nums,n,start,pivotIndex-1);
        }else{
            return findNthOrder(nums,n,pivotIndex+1,end);
        }

    }

    public static void main(String[] args) {
        int[] input = {7,6,5,4,3,2,1};
        findKthLargest(input,2);
    }
}
