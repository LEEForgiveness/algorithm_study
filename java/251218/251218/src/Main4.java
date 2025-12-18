import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            if(input == 0){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            } else {
                stack.push(input);
            }
        }
        int result = 0;
        for (int i = 0; i < stack.size(); i++) {
            result += stack.get(i);
        }
        System.out.println(result);
    }
}
