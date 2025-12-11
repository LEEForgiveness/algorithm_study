import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        solution(s);
        System.out.println("solution(s2): " + solution(s2));
        System.out.println("solution(s3): " + solution(s3));
        System.out.println("solution(s4): " + solution(s4));
    }

    static boolean solution(String s){
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(c);
            } else {
                if (stack.empty()){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();
    }
}