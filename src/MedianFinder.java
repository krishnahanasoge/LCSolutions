import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    private Queue<Integer> lowers;
    private Queue<Integer> highers;
    public MedianFinder() {
        this.lowers = new PriorityQueue<>((a, b)->{
            return b-a;
        });
        this.highers = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(lowers.size() == 0 || num < lowers.peek()){
            lowers.add(num);
        }else{
            highers.add(num);
        }
        if(lowers.size() == highers.size()){
            return;
        }else if(lowers.size() - highers.size() == 2){
            highers.add(lowers.poll());
        }else{
            lowers.add(highers.poll());
        }
    }

    public double findMedian() {
        if(lowers.size() == highers.size()){
            return (double)(lowers.peek() + highers.peek())/2;
        }else if(lowers.size() > highers.size()){
            return (double)lowers.peek();
        }else{
            return (double)highers.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
