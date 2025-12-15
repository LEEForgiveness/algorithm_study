import java.util.Stack;

public class Main8 {
    public static void main(String[] args) {
        System.out.println(solve("(())("));
        System.out.println(solve("(())())"));
        System.out.println(solve("()()()"));
        System.out.println();
    }

    static boolean solve(String st){
        Stack<String> stack = new Stack<>();
        char[] chars = st.toCharArray();
        for (char c: chars){
            if(c == '('){
                stack.push(String.valueOf(c));
            } else {
                if(stack.isEmpty()){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
