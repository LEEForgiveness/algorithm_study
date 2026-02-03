import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<int[]> trangle = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            trangle.add(input);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    trangle.get(i)[j] = trangle.get(i - 1)[j] + trangle.get(i)[j];
                } else if (j == i){
                    trangle.get(i)[j] = trangle.get(i - 1)[j - 1] + trangle.get(i)[j];
                } else {
                    trangle.get(i)[j] += Math.max(trangle.get(i - 1)[j - 1], trangle.get(i - 1)[j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, trangle.get(n - 1)[i]);
        }
        System.out.println(max);
    }
}
