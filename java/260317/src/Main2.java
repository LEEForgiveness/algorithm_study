import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static int n, m;
    static int[][] map;
    static int min = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(bf.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        bfs();
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0 , -1, 0};
    static void bfs(){
        int[][][] dist = new int[n][m][2];
        dist[0][0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            int broken = cur[2];
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                if (0 <= nextC && nextC < m && 0 <= nextR && nextR < n && map[nextR][nextC] == 0 && dist[nextR][nextC][broken] == 0) {
                    queue.add(new int[] {nextR, nextC, broken});
                    dist[nextR][nextC][broken] = dist[curR][curC][broken] + 1;
                }

                if (0 <= nextC && nextC < m && 0 <= nextR && nextR < n && map[nextR][nextC] == 1 && broken == 0 && dist[nextR][nextC][1] == 0) {
                    queue.add(new int[] {nextR, nextC, 1});
                    dist[nextR][nextC][1] = dist[curR][curC][0] + 1;
                }
            }
        }

        if (dist[n - 1][m - 1][0] == 0 && dist[n - 1][m - 1][1] == 0) {
            System.out.println(-1);
        } else if (dist[n - 1][m - 1][0] == 0) {
            System.out.println(dist[n - 1][m - 1][1]);
        } else if (dist[n - 1][m - 1][1] == 0) {
            System.out.println(dist[n - 1][m - 1][0]);
        } else {
            System.out.println(Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]));
        }
    }
}
