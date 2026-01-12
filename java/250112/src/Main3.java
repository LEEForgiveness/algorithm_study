import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> rank = new HashMap<>();
        int[] numbers = new int[n];
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sorted[i] = numbers[i];
        }
        Arrays.sort(sorted);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(rank.containsKey(sorted[i])){
                continue;
            }
            rank.put(sorted[i], count);
            count++;
        }

        for (int i = 0; i < n; i++) {
            int rk = rank.get(numbers[i]);
            sb.append(rk).append(" ");
        }

        System.out.println(sb.toString());
    }
}
