import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 1;
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(bf.readLine());
            if(stack.contains(value)){
                int pop = stack.pop();
                if(pop != value){
                    System.out.println("NO");
                    return;
                }
                sb.append("-\n");
                continue;
            }
            for (int j = count; j <= value; j++) {
                stack.add(j);
                sb.append("+\n");
                count = value + 1;
            }
            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb.toString());
    }
}