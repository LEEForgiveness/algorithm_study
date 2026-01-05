import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = (Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        int[][] visited = new int[N][M];
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2){
                    startY = i;
                    startX = j;
                    break;
                }
            }
        }
        bfs(map, visited, startX, startY);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0 && map[i][j] == 1){
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]);
                if(j != M - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int[][] map, int[][] visited, int startX, int startY){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startY, startX});
        map[startY][startX] = 0;
        visited[startY][startX] = 1;

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
//            System.out.println("currentY: " + xy[0] + " currentX: " + xy[1]);
            visited[xy[0]][xy[1]] = 1;
//            for (int i = 0; i < map.length; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();
            for (int i = 0; i < 4; i++) {
                int nowX = xy[1] + dx[i];
                int nowY = xy[0] + dy[i];
                if (check(map.length, map[0].length, nowX, nowY) && map[nowY][nowX] == 1 && visited[nowY][nowX] == 0) {
                    queue.add(new int[]{nowY, nowX});
                    visited[nowY][nowX] = 1;
                    map[nowY][nowX] = map[xy[0]][xy[1]] + 1;
                }
            }
        }
    }
    static boolean check(int N, int M, int nowX, int nowY){
        if (nowX >= 0 && nowX < M && nowY >= 0 && nowY < N) {
            return true;
        } else {
            return false;
        }
    }
}
