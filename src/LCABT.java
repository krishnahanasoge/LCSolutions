import java.util.ArrayList;
import java.util.List;

public class LCABT {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        node1.left = node2;
        lowestCommonAncestor(node1, node1, node2);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathToP = new ArrayList<>();
        List<TreeNode> pathToQ = new ArrayList<>();
        findPath(root, p, pathToP);
        findPath(root, q, pathToQ);
        if(pathToP.isEmpty() || pathToQ.isEmpty()){
            return null;
        }
        int size = pathToP.size() > pathToQ.size() ? pathToQ.size() : pathToP.size();
        TreeNode result = root;
        for(int i=0;i<size;i++){
            if(pathToP.get(i).val == pathToQ.get(i).val){
                result = pathToP.get(i);
            }else{
                break;
            }
        }
        return result;
    }

    public static void findPath(TreeNode node, TreeNode target, List<TreeNode> result){
        result.add(node);
        if(node == null || (node.left == null && node.right == null)){
            result.clear();
        }else if(node.val == target.val){
            return;
        }else if(target.val < node.val){
            findPath(node.left, target, result);
        }else if(target.val > node.val){
            findPath(node.right, target, result);
        }
    }
}
