import java.util.PriorityQueue;

public class RunningMedian {
    static PriorityQueue<Integer> lowers = new PriorityQueue<>((o1,o2) -> {
        return -1*o1.compareTo(o2);
    });
    static PriorityQueue<Integer> highers = new PriorityQueue<>();

    public static void main(String args[]){
        int[] arr = {1,3,5,2,8,6};
        double[] result = findRunningMedian(arr);
        for(double median : result){
            System.out.println(median);
        }
    }

    public static double[] findRunningMedian(int[] arr){
        double[] medians = new double[arr.length];
        for(int i=0;i<arr.length;i++){
            if(lowers.size()==0 || lowers.peek()>arr[i]){
                lowers.add(arr[i]);
            }else{
                highers.add(arr[i]);
            }
            reheapify();
            medians[i] = getMedian();
        }
        return medians;
    }

    public static void reheapify(){
        if(Math.abs(lowers.size()-highers.size())<2){
            return;
        }else{
            if(lowers.size() > highers.size()){
                highers.add(lowers.poll());
            }else{
                lowers.add(highers.poll());
            }
        }
    }

    public static double getMedian(){
        if(lowers.size() > highers.size()){
            return lowers.peek().doubleValue();
        }else if(highers.size() > lowers.size()){
            return highers.peek().doubleValue();
        }else{
            return ((Integer)(lowers.peek() + highers.peek())).doubleValue()/2;
        }
    }
}
