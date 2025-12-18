import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(bf.readLine());
            Map<String, Integer> clothes = new HashMap<>();
            int result = 1;
            for (int j = 0; j < n; j++) {
                String[] cloth = bf.readLine().split(" ");
                clothes.put(cloth[1], clothes.getOrDefault(cloth[1], 0) + 1);
            }
            for (String key: clothes.keySet()){
                result = result * (clothes.get(key) + 1);
            }
            System.out.println(result - 1);
        }
    }
}
