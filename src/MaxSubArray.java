public class MaxSubArray {
    static Long max_sum = 0L;
    static Long maxSumPrevIndex = ((Integer)(Integer.MIN_VALUE)).longValue();
    public static int maxSubArray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            long maxSumCurrIndex = Math.max(nums[i],nums[i]+maxSumPrevIndex);
            maxSumPrevIndex = maxSumCurrIndex;
            if(maxSumCurrIndex > max_sum){
                max_sum = maxSumCurrIndex;
            }
        }
        return max_sum.intValue();
    }

    public static void main(String args[]){
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(input);
    }
}
