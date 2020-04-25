public class MinStepsToEnd {
    public static int jump(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0;

        int jumpNum = 1;
        int curMaxIdx = nums[0];
        int nextMaxIdx = nums[0];

        for(int i=1; i<nums.length; i++){
            // for every element, decide the max jump range.
            nextMaxIdx = (i + nums[i] > nextMaxIdx) ? (i + nums[i]) : nextMaxIdx;

            // when arrived at the current max index, it should have a jump.
            // no need to remember where to jump.
            if(i == curMaxIdx && i != nums.length - 1){
                curMaxIdx = nextMaxIdx;
                jumpNum++;
            }

            if(curMaxIdx >= nums.length - 1) break;
        }

        return jumpNum;
    }

    public static void main(String args[]){
        int[] nums = {1,2,3,1,1,1};
        System.out.print(jump(nums));
    }
}
