import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int[][] dp = new int [41][2];
        dp[0] = new int[] {1, 0};
        dp[1] = new int[] {0, 1};
        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(bf.readLine());
            int[] output = fibo(dp, input);
            System.out.println(output[0] + " " + output[1]);
        }
    }
    static int[] fibo(int[][] dp, int input){
        if(dp[input][0] != 0 || dp[input][1] != 0){
            return dp[input];
        }
        int[] prev1 = fibo(dp, input - 1);
        int[] prev2 = fibo(dp, input - 2);
        dp[input][0] = prev1[0] + prev2[0];
        dp[input][1] = prev1[1] + prev2[1];

        return dp[input];
    }
}
