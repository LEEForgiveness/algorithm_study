import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            int inputCount = Integer.parseInt(bf.readLine());
            PriorityQueue<Integer> q1 = new PriorityQueue<>(); //우선순위 낮은 순
            PriorityQueue<Integer> q2 = new PriorityQueue<>(Comparator.reverseOrder()); //우선순위 높은 순
            Map<Integer, Integer> numberCount = new HashMap<>();
            for (int j = 0; j < inputCount; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    q1.add(number);
                    q2.add(number);
                    numberCount.put(number, numberCount.getOrDefault(number, 0) + 1);
                } else if (command.equals("D") && number == -1) {
                    if (numberCount.isEmpty()) {
                        continue;
                    } else {
                        remove(q1, numberCount);
                    }
                } else if (command.equals("D") && number == 1){
                    if (numberCount.isEmpty()) {
                        continue;
                    } else {
                        remove(q2, numberCount);
                    }
                }
            }
            int max = -2147483647;
            int min = 2147483647;
            int size = numberCount.size();
            if (size > 0) {
                if (size == 1) {
                    for (Integer key : numberCount.keySet()) {
                        min = Math.min(min, key);
                    }
                    System.out.println(min + " " + min);
                } else {
                    for (Integer key : numberCount.keySet()) {
                        max = Math.max(max, key);
                        min = Math.min(min, key);
                    }
                    System.out.println(max + " " + min);
                }
            } else {
                System.out.println("EMPTY");
            }
        }
    }

    static void remove(PriorityQueue<Integer> queue, Map<Integer, Integer> numberCount){
        int pollNumber;
        while (true){
            if (!queue.isEmpty()){
                int pop = queue.poll();
                if (numberCount.getOrDefault(pop, 0) == 0) {
                    numberCount.remove(pop);
                    continue;
                } else {
                    numberCount.put(pop, numberCount.getOrDefault(pop, 0) - 1);
                    if (numberCount.get(pop) == 0) {
                        numberCount.remove(pop);
                    }
                    pollNumber = pop;
                    break;
                }
            } else {
                break;
            }
        }
    }
}
