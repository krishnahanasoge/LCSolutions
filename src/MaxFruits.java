import java.util.*;

public class MaxFruits {
    public static void main(String args[]){
        int[] input = {1,0,1,4,1,4,1,2,3};
        totalFruit(input);
    }

    public static int totalFruit(int[] tree) {
        List<Integer> treeList = new ArrayList<>();
        Map<Integer,Integer> treeMap = new HashMap<>();
        int maxFruits = 0;
        int i = 0;
        int elementsRemoved = 0;
        while(i<=tree.length-1){//4<=4
            treeList.add(tree[i]);//2,3,2,2
            treeMap.put(tree[i],i-elementsRemoved);//2,3
            if(treeMap.size()>2){
                int firstFruit = treeList.get(0);//1
                for(int j=0;j<=treeMap.get(firstFruit);j++){
                    treeList.remove(0);
                    elementsRemoved++;
                }
                treeMap = new HashMap<>();
                for(int k=0;k<treeList.size();k++){
                    treeMap.put(treeList.get(k),k);
                }
            }else if(maxFruits<treeList.size()){//3<4
                maxFruits = treeList.size();//4
            }
            i++;
        }
        return maxFruits;
    }
}
