import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static final long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        while(T --> 0){
            System.out.println(solve(Integer.parseInt(bf.readLine())));
        }

    }

    static long solve(int n){
        if (n == 1 || n == 2 || n == 3) {
            return dp[n];
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];

        }

        return dp[n];
    }
}
