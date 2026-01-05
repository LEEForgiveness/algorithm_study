import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        while(N --> 0){
            int input = Integer.parseInt(bf.readLine());
            if (input == 0) {
                if (heap.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(heap.poll());
                }
            } else {
                heap.add(input);
            }
        }
    }
}
