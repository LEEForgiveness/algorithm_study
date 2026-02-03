import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = graph[1][1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

//            System.out.println("x1: " + x1 + " y1: " + y1);
//            System.out.println("x2: " + x2 + " y2: " + y2);
            if (x1 == x2 && y1 == y2) {
                System.out.println(graph[x1][y1]);
            } else {
//                System.out.println(getSumDp(graph, dp, x1 - 1, y2));
//                System.out.println(getSumDp(graph, dp, x2, y1 - 1));
//                System.out.println(getSumDp(graph, dp, x1 - 1, y1 - 1));
                System.out.println(getSumDp(graph, dp, x2, y2) - getSumDp(graph, dp, x1 - 1, y2) - getSumDp(graph, dp, x2, y1 - 1) + getSumDp(graph, dp, x1 - 1, y1 - 1));
            }
        }

//        for (int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
    }
    //dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + graph[i][j];
    static int getSumDp(int[][] graph, int[][] dp, int i, int j){
        if (i == 0 || j == 0){
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        dp[i][j] = getSumDp(graph, dp, i, j - 1) + getSumDp(graph, dp, i - 1, j) - getSumDp(graph, dp, i - 1, j - 1) + graph[i][j];
        return dp[i][j];
    }
}
