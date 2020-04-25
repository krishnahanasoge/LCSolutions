import java.util.LinkedList;
import java.util.List;

class TreeNod{
    int val;
    TreeNod left;
    TreeNod right;
    TreeNod(int val){
        this.val = val;
    }
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNod root) {
        StringBuilder result = new StringBuilder();
        if(root == null){
            return result.toString();
        }
        List<TreeNod> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while(!queue.isEmpty() && count > 0){
            TreeNod node = queue.remove(0);
            if(result.length() == 0){
                result.append(node.val);
            }else{
                result.append("><");
                result.append(node == null ? "null" : node.val);
            }
            if(node != null){
                count--;
                if(node.left != null){
                    count++;
                }
                if(node.right != null){
                    count++;
                }
            }
            if(count > 0){
                queue.add(node == null ? null : node.left);
                queue.add(node == null ? null : node.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNod deserialize(String data) {
        String[] dataArr = data.split("><");
        if(data.length()==0){
            return null;
        }
        TreeNod root = new TreeNod(Integer.valueOf(dataArr[0]));
        if(dataArr.length == 1){
            return root;
        }
        List<TreeNod> queue = new LinkedList<>();
        queue.add(root);
        int i=0;
        while(2*i+1<dataArr.length && !queue.isEmpty()){
            if(!dataArr[i].equals("null")){
                TreeNod node = queue.remove(0);
                String leftNodeVal = dataArr[2*i+1];
                TreeNod leftNode = leftNodeVal.equals("null") ? null : new TreeNod(Integer.valueOf(leftNodeVal));
                if(leftNode != null){
                    node.left = leftNode;
                    queue.add(node.left);
                }
                if(2*i+2<dataArr.length){
                    String rightNodeVal = dataArr[2*i+2];
                    TreeNod rightNode = rightNodeVal.equals("null") ? null : new TreeNod(Integer.valueOf(rightNodeVal));
                    if(rightNode != null){
                        node.right = rightNode;
                        queue.add(node.right);
                    }
                }
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNod treeNod1 = new TreeNod(1);
        TreeNod treeNod2 = new TreeNod(2);
        TreeNod treeNod3 = new TreeNod(3);
        TreeNod treeNod4 = new TreeNod(4);
        TreeNod treeNod5 = new TreeNod(5);
        TreeNod treeNod6 = new TreeNod(6);
        TreeNod treeNod7 = new TreeNod(7);
        treeNod1.left = treeNod2;
        treeNod1.right = treeNod3;
        //treeNod2.left = treeNod4;
        //treeNod2.right = treeNod5;
        treeNod3.left = treeNod4;
        treeNod3.right = treeNod5;
        Codec codec = new Codec();
        TreeNod result = codec.deserialize(codec.serialize(null));
        System.out.println(result);

    }
}