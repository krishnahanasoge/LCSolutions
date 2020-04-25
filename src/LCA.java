import java.util.ArrayList;
import java.util.List;

public class LCA {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNodeP = new TreeNode(5);
        TreeNode treeNodeQ = new TreeNode(4);
        treeNode.left = treeNodeP;
        treeNode.right = new TreeNode(1);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = treeNodeQ;
        treeNode.right.left = new TreeNode(0);
        treeNode.right.left = new TreeNode(8);
        LCA lca = new LCA();
        lca.lowestCommonAncestor(treeNode, treeNodeP, treeNodeQ);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        List<TreeNode> pathToP = findPathToNode(root, p);
        List<TreeNode> pathToQ = findPathToNode(root, q);
        if(pathToP.isEmpty() || pathToQ.isEmpty()){
            return null;
        }
        int size = pathToP.size()>=pathToQ.size()?pathToP.size():pathToQ.size();
        for(int i=0;i<size;i++){
            if(i>(pathToP.size()-1) || i>(pathToQ.size()-1)){
                return result;
            }
            if(pathToP.get(i).val==pathToQ.get(i).val){
                result = pathToP.get(i);
            }else{
                break;
            }
        }
        return result;
    }

    public List<TreeNode> findPathToNode(TreeNode node, TreeNode nodeFind){
        List<TreeNode> result = new ArrayList<>();
        if(node == null){
            return result;
        }
        if(node.val == nodeFind.val){
            result.add(node);
            return result;
        }
        List<TreeNode> leftResult = findPathToNode(node.left,nodeFind);
        List<TreeNode> rightResult = findPathToNode(node.right,nodeFind);
        if(!leftResult.isEmpty()){
            result.add(node);
            result.addAll(leftResult);
        }else if(!rightResult.isEmpty()){
            result.add(node);
            result.addAll(rightResult);
        }
        return result;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
