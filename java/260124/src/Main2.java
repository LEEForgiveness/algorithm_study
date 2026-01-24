import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] tomatoes = new int[h][n][m];
        int[][][] visited = new int[h][n][m];
        boolean isDone = true;
        int max = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                tomatoes[i][j] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
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
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (visited[i][j][k] == 0 && tomatoes[i][j][k] == 1) {
                            bfs(tomatoes, visited, m, n, h, i, j, k);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(Arrays.toString(tomatoes[i][j]));
            }
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

    static void bfs(int[][][] tomatoes, int[][][] visited, int m, int n, int h, int startH,
        int startR, int startC) {
        int[] start = new int[]{startH, startR, startC};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[startH][startR][startC] = 1;
        while (!queue.isEmpty()) {
            System.out.println(Arrays.toString(queue.element()));
            int[] cur = queue.poll();
            int curH = cur[0];
            int curR = cur[1];
            int curC = cur[2];

            for (int i = 0; i < 6; i++) {
                int newR = curR + dr[i];
                int newC = curC + dc[i];
                int newH = curH + dh[i];
                if (0 <= newR && newR < n && 0 <= newC && newC < m && 0 <= newH && newH < h
                    && visited[newH][newR][newC] != 1
                    && tomatoes[newH][newR][newC] == 0) {
                    queue.add(new int[]{newH, newR, newC});
                    visited[newH][newR][newC] = 1;
                    tomatoes[newH][newR][newC] = tomatoes[curH][curR][curC] + 1;
                }
            }

        }
    }
}
