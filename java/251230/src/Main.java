import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            String input = bf.readLine();
            map.put(i, input);
            map2.put(input, i);
        }

        for (int i = 0; i < m; i++) {
            String input = bf.readLine();
            boolean number = isNumber(input);
            if(number){
                System.out.println(map.get(Integer.parseInt(input)));
            } else {
                System.out.println(map2.get(input));
            }
        }
    }

    static boolean isNumber(String input) {
        return input.matches("^\\d+$");
    }
}
