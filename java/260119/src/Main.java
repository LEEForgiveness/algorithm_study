import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        while(n --> 0){
            int input = Integer.parseInt(bf.readLine());
            if (input == 0 && !heap.isEmpty()) {
                System.out.println(heap.poll());
            } else if (input == 0 && heap.isEmpty()) {
                System.out.println(0);
            } else {
                heap.add(input);
            }
        }
    }
}
