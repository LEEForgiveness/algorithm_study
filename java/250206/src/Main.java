import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(map, visited, n, m, i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void dfs(int[][] map, boolean[][] visited, int n, int m, int i, int j, int score, int depth){
        if (depth == 4) {
            max = Math.max(max, score);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nowR = i + dr[k];
            int nowC = j + dc[k];
            if (0 <= nowR && nowR < n && 0 <= nowC && nowC < m && !visited[nowR][nowC]) {
                if (depth == 2) {
                    visited[nowR][nowC] = true;
                    dfs(map, visited, n, m, i, j, score + map[nowR][nowC], depth + 1);
                    visited[nowR][nowC] = false;
                }
                visited[nowR][nowC] = true;
                dfs(map, visited, n, m, nowR, nowC, score + map[nowR][nowC], depth + 1);
                visited[nowR][nowC] = false;
            }
        }
    }
}
