import java.util.Arrays;

public class ArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        int median = nums.length/2;
        TreeNode root = new TreeNode(nums[median]);
        if(nums.length == 1){
            return root;
        }
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,median));
        if(median+1<nums.length){
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums,median+1,nums.length));
        }
        return root;
    }

    public static void main(String[] args) {
        int[] input = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(input);
        System.out.println(root);
    }
}
