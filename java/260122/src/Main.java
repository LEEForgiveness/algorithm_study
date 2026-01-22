import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = bf.readLine()) != null) {
            int n = Integer.parseInt(input);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.pow(3, n); i++) {
                sb.append("-");
            }
            System.out.println(kantour(sb.toString()));
        }
    }

    static String kantour(String s){
        if (s.length() == 1) {
            return s;
        }
        String result;
        String left = kantour(s.substring(0, s.length()/3));
        String right = kantour(s.substring(2 * s.length() / 3));
        String middle = " ".repeat(s.length() / 3);
        result = left + middle + right;
        return result;
    }
}
