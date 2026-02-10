import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] house;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        dp = new int[n][3];
        house = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = house[0][0];
        dp[0][1] = house[0][1];
        dp[0][2] = house[0][2];
        System.out.println(Math.min(Math.min(cost(n - 1, 0), cost(n - 1, 1)),cost(n - 1, 2)));
    }

    static int cost(int n, int color){
        if (dp[n][color] != 0) {
            return dp[n][color];
        }
        if (color == 0) {
            dp[n][color] = Math.min(cost(n - 1, 1), cost(n - 1, 2)) + house[n][0];
        }
        if (color == 1) {
            dp[n][color] = Math.min(cost(n - 1, 0), cost(n - 1, 2)) + house[n][1];
        }
        if (color == 2) {
            dp[n][color] = Math.min(cost(n - 1, 0), cost(n - 1, 1)) + house[n][2];
        }

        return dp[n][color];
    }
}