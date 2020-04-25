import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public static void main(String[] args) {
        int[] input = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(input);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val = nums[Math.abs(nums[i])-1];
            if(val>0){
                nums[Math.abs(nums[i])-1] = val*-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(nums[i]);
            }
        }
        return result;
    }
}
