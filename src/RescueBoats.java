import java.util.Arrays;

public class RescueBoats {
    public static void main(String[] args) {
        int[] input = {3,2,2,1};
        numRescueBoats(input,3);
    }

    public static int numRescueBoats(int[] people, int limit) {
        int result = 0;
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        while(i<j){
            while(people[i]+people[j]<limit && i<people.length-1){
                i++;
            }
            if(people[i]+people[j]==limit){
                result++;
                people[i]=-1;
                people[j]=-1;
                i++;
                j--;
            }else if(people[i]+people[j]>limit){
                if(people[j]<limit){
                    people[i-1]=-1;
                }
                result++;
                people[j]=-1;
                j--;
            }
        }
        for(int k=0;k<people.length;k++){
            if(people[k]!=-1){
                result++;
            }
        }
        return result;
    }
}
