import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main4 {
    static int[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                graph[i][j] = 1000000000;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(graph[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if (value < graph[start][end]) {
                graph[start][end] = value;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(graph[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1000000000) {
                    System.out.print(0);
                } else {
                    System.out.print(graph[i][j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
