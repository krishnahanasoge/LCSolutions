import java.util.Arrays;

public class Robber {

    public static int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(nums[0]+rob(Arrays.copyOfRange(nums,2,nums.length)),rob(Arrays.copyOfRange(nums,1,nums.length)));
    }

    public static void main(String args[]){
        int[] input = {1,2,3,1};
        System.out.print(rob(input));
    }
}
