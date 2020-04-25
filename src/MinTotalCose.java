import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MinTotalCose {

    public static int twoCitySchedCost(int[][] costs) {
        Set<Integer> indexSetForFirst = new HashSet<>();
        Set<Integer> indexSetForSecond = new HashSet<>();
        ArrayList<Integer> differenceListFirst = new ArrayList<>();
        ArrayList<Integer> differenceListSecond = new ArrayList<>();
        int totalCandidates = costs.length;
        int minCost = 0;
        for(int i=0; i<totalCandidates; i++){
            int difference = costs[i][0] - costs[i][1];
            if(difference < 0){
                minCost+=costs[i][0];
                indexSetForFirst.add(i);
                differenceListFirst.add(Math.abs(difference));
            }else{
                minCost+=costs[i][1];
                indexSetForSecond.add(i);
                differenceListSecond.add(difference);
            }
        }
        int numberOfElemsToBeMoved = indexSetForFirst.size()>indexSetForSecond.size()?indexSetForFirst.size()- (costs.length/2):indexSetForSecond.size()-(costs.length/2);
        if(numberOfElemsToBeMoved==0){
            return minCost;
        }else if(indexSetForFirst.size()<indexSetForSecond.size()){
            Collections.sort(differenceListSecond);
            for(int i = 0; i<Math.abs(numberOfElemsToBeMoved);i++){
                minCost+=Math.abs(differenceListSecond.get(i));
            }
        }else{
            Collections.sort(differenceListFirst);
            for(int i = 0; i<numberOfElemsToBeMoved;i++){
                minCost+=Math.abs(differenceListFirst.get(i));
            }
        }
        return minCost;
    }

    public static void main(String args[]){
        int[][] arr = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        twoCitySchedCost(arr);
    }
}
