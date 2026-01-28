import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] fruits = new int[n];
        Map<Integer, Integer> fruitsCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            fruits[i] = input;
        }
        int left = 0;
        int lenght = 0;
        for (int right = 0; right < n; right++) {
            fruitsCount.put(fruits[right], fruitsCount.getOrDefault(fruits[right], 0) + 1);
            while (fruitsCount.size() > 2){
                fruitsCount.put(fruits[left], fruitsCount.get(fruits[left]) - 1);
                if (fruitsCount.get(fruits[left]) == 0) {
                    fruitsCount.remove(fruits[left]);
                }
                left++;
            }
            lenght = Math.max(lenght, right - left + 1);
        }
        System.out.println(lenght);
    }
}