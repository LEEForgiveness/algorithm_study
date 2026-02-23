import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] equipment;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        equipment = new int[n + 1][2];
        dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            equipment[i][0] = weight;
            equipment[i][1] = value;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j < equipment[i][0]) {
                    dp[j][i] = dp[j][i - 1];
                } else {
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j - equipment[i][0]][i - 1] + equipment[i][1]);
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}
