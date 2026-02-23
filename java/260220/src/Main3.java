import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main3 {
    static class item{
        int weight;
        int value;

        public item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    static List<item> arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr.add(new item(weight, value));
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (arr.get(i).weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - i] + arr.get(i).value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n - 1][k]);
    }
}
