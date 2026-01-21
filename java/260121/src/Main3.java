import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            char[] input = bf.readLine().toCharArray();
            int n = Integer.parseInt(bf.readLine());
            String inputArr = bf.readLine();
            inputArr = inputArr.substring(1, inputArr.length() - 1);
            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] parts = inputArr.split(",");
                for (String part : parts) {
                    deque.add(Integer.parseInt(part));
                }
            }
            boolean rotate = false;
            boolean error = false;
            for (int j = 0; j < input.length; j++) {
                if (input[j] == 'R') {
                    if (rotate) {
                        rotate = false;
                    } else {
                        rotate = true;
                    }
                } else {
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    } else {
                        if (rotate) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
            }
            if (error){
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(rotate ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb.toString());
            }
        }
    }
}
