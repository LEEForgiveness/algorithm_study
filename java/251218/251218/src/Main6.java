import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            switch (input){
                case "top":
                    if(stack.isEmpty()){
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
                case "size":
                    if(stack.isEmpty()){
                        System.out.println("0");
                    } else {
                        System.out.println(stack.size());
                    }
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                default:
                    String[] strings = input.split(" ");
                    stack.push(Integer.valueOf(strings[1]));
                    break;
            }
        }
    }
}
