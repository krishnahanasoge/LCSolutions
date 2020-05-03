import java.util.ArrayList;
import java.util.List;

public class EightHouses {
    public static List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> statesList = new ArrayList<>();
        for(int state: states){
            statesList.add(state);
        }
        List<Integer> tempStatesList = new ArrayList<>();
        int day = 1;
        while(day <= days){
            for(int i=0;i<statesList.size();i++){
                if(i==0){
                    tempStatesList.add(statesList.get(i+1)=='1'?1:0);
                }else if(i==statesList.size()-1){
                    tempStatesList.add(statesList.get(i-1)=='1'?1:0);
                }else{
                    tempStatesList.add(statesList.get(i-1)!=statesList.get(i+1)?1:0);
                }
            }
            statesList = tempStatesList;
            tempStatesList = new ArrayList<>();
            day++;
        }
        return statesList;
    }

    public static void main(String[] args) {
        int[] states = {1,1,1,0,1,1,1,1};
        cellCompete(states, 2);

    }
}
