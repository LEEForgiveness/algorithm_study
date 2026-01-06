import java.util.*;
import java.io.*;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[n][m];
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            tomato[i] = (Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt)).toArray();
        }



        System.out.println(bfs(tomato, visited, n, m));
    }
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1 , 0, 1};
    static int bfs(int[][] tomato, int[][] visited, int n, int m){
        Queue<int[]> queue = new LinkedList<>();
        int startX = 0;
        int startY = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tomato[i][j] == 1){
                    startX = j;
                    startY = i;
                    queue.add(new int[] {startY, startX});
                    visited[startY][startX] = 1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nowY = cur[0] + dy[i];
                int nowX = cur[1] + dx[i];

                if(0 <= nowX && nowX < tomato[0].length && 0 <= nowY && nowY < tomato.length && tomato[nowY][nowX] == 0 && visited[nowY][nowX] == 0){
                    queue.add(new int[] {nowY, nowX});
                    visited[nowY][nowX] = 1;
                    tomato[nowY][nowX] = tomato[cur[0]][cur[1]] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(tomato[i]));
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tomato[i][j] == 0){
                    return -1;
                }
                if (max < tomato[i][j]){
                    max = tomato[i][j];
                }
            }
        }
        return max - 1;
    }
}
