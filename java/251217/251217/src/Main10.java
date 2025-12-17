import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main10 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> cards = new LinkedList<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= N; i++) {
            cards.add(i);
        }
        while(cards.size() != 1){
            cards.poll();
            int input = cards.poll();
            cards.add(input);
        }
        System.out.println(cards.poll());
    }
}
