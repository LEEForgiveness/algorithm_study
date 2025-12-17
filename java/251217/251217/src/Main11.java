import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String line = bufferedReader.readLine();
            if (line.equals(".")){
                break;
            }
            System.out.println(solve(line));
        }
    }

    static String solve(String line){
        char[] chars = line.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            if (c == ')') {
                if(stack.isEmpty() || stack.peek() != '('){
                    return "no";
                }
                stack.pop();
            }
            if (c == ']') {
                if(stack.isEmpty() || stack.peek() != '['){
                    return "no";
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
