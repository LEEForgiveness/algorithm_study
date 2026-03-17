import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dr = {1, 0, -1 ,0};
    static int[] dc = {0, 1, 0, -1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        List<int[]> start = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 2) {
                    start.add(new int[] {i, j});
                }
                map[i][j] = input;
            }
        }
        makeWall(0, start);
        System.out.println(max);
    }

    //벽 만들기 dfs
    static void makeWall(int depth, List<int[]> start){
        if (depth == 3) {
            bfs(start);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(depth + 1, start);
                    map[i][j] = 0;
                }
            }
        }
    }

    //바이러스가 퍼지는 bfs
    static void bfs(List<int[]> start){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int[] s: start) {
            queue.add(s);
            visited[s[0]][s[1]] = true;
        }

        // tempMap = map.clone();하면 바깥부분만 새로 만들고 안에 배열은 얕은 복사가 일어남.
        // 그래서 for문으로 안에 까지 깊은 복사를 하는 거임.
        int[][] tempMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            tempMap[i] = map[i].clone();
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curC = cur[0];
            int curR = cur[1];
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
//                System.out.println(nextR);
//                System.out.println(nextC);
                if (0 <= nextC && nextC < n && 0 <= nextR && nextR < m && !visited[nextC][nextR] && tempMap[nextC][nextR] == 0) {
                    tempMap[nextC][nextR] = 2;
                    queue.add(new int[] {nextC, nextR});
                    visited[nextC][nextR] = true;
                }
            }
        }

        getCountSafeZone(tempMap);
    }

    static void getCountSafeZone(int[][] tempMap){
        int count = 0;
        for (int i = 0; i < tempMap.length; i++) {
            for (int j = 0; j < tempMap[0].length; j++) {
                if (tempMap[i][j] == 0) {
                    count++;
                }
            }
        }
        max = Math.max(max, count);
    }
}
