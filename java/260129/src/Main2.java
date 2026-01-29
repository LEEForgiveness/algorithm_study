import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int maxTotal = 0;
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(maxTotal);
    }



    static void dfs(int startR, int startC, int sum, int depth){
        if (depth == 4) {
            maxTotal = Math.max(sum, maxTotal);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nowR = startR + dr[i];
            int nowC = startC + dc[i];

            if (0 <= nowC && nowC < m && 0 <= nowR && nowR < n) {
                if (depth == 2) {
                    visited[nowR][nowC] = true;
                    dfs(startR, startC, sum + map[nowR][nowC], depth + 1);
                    visited[nowR][nowC] = false;
                } else {
                    visited[nowR][nowC] = true;
                    dfs(nowR, nowC, sum + map[nowR][nowC], depth + 1);
                    visited[nowR][nowC] = false;
                }
            }
        }
    }
}
