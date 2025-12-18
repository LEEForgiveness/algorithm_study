import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            switch (input){
                case "front":
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    } else {
                        System.out.println(queue.peek());
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    } else {
                        for (int j = 0; j < queue.size() - 1; j++) {
                            int output = queue.poll();
                            queue.add(output);
                        }
                        System.out.println(queue.peek());
                        int back = queue.poll();
                        queue.add(back);
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    } else {
                        System.out.println(queue.poll());
                    }
                    break;
                default:
                    String[] strings = input.split(" ");
                    queue.add(Integer.valueOf(strings[1]));
                    break;
            }
        }
    }
}
