import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        int t = Integer.parseInt(bf.readLine());
        int[] input = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bf.readLine());
            input[i] = n;
            max = Math.max(max, n);
        }
        for (int j = 2; j <= max; j++) {
            if (j - 4 < 0){
                dp[j] = dp[j - 1] * 2;
            } else {
                dp[j] = dp [j - 1] * 2 - dp[j - 4];
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println(dp[input[i]]);
        }
    }
}
