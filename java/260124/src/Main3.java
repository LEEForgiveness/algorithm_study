import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomatoes = new int[h][n][m];
        boolean isDone = true;
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(bf.readLine());
                for (int k = 0; k < m; k++) {
                    int input = Integer.parseInt(st.nextToken());
                    tomatoes[i][j][k] = input;
                    if (input == 1) {
                        queue.add(new int[] {i, j, k});
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        isDone = false;
                        break;
                    }
                }
            }
        }
        if (!isDone) {
            bfs(tomatoes, queue, m, n, h);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    } else {
                        max = Math.max(max, tomatoes[i][j][k]);
                    }
                }
            }
        }
        System.out.println(max - 1);
    }

    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dr = {0, 1, 0, -1, 0, 0};
    static int[] dc = {1, 0, -1, 0, 0, 0};

    static void bfs(int[][][] tomatoes, Queue<int[]> queue, int m, int n, int h) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curH = cur[0];
            int curR = cur[1];
            int curC = cur[2];

            for (int i = 0; i < 6; i++) {
                int newR = curR + dr[i];
                int newC = curC + dc[i];
                int newH = curH + dh[i];
                if (0 <= newR && newR < n && 0 <= newC && newC < m && 0 <= newH && newH < h
                    && tomatoes[newH][newR][newC] == 0) {
                    queue.add(new int[]{newH, newR, newC});
                    tomatoes[newH][newR][newC] = tomatoes[curH][curR][curC] + 1;
                }
            }

        }
    }
}
