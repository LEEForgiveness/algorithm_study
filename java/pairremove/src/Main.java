import java.util.Stack;

class Solution
{
    public static int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        String[] strings = s.split("");
        for(String string: strings){
            if(!stack.empty() && stack.peek().equals(string)){
                stack.pop();
            }
            else {
                stack.push(string);
            }
            System.out.println(stack);
        }

        if(stack.empty()){
            return 1;
        }
        else {
            return 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution("baabaa"));
        System.out.println(Solution.solution("cdcd"));
    }
}