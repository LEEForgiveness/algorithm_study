import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            char[] inputs = bufferedReader.readLine().toCharArray();
            solve(inputs);
        }
    }
    static void solve(char[] inputs){
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < inputs.length; j++) {
            if (inputs[j] == '(') {
                stack.push(inputs[j]);
            } else {
                if (stack.isEmpty()){
                    System.out.println("NO");
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
