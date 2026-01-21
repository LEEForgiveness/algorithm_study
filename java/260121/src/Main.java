import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = bf.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'I') {
                    bfs(map, visited, i, j);
                }
            }
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(char[][] map, boolean[][] visited, int startY, int startX){
        int person = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startY, startX});
        visited[startY][startX] = true;
        while(!queue.isEmpty()){
            int[] pop = queue.poll();
            int curY = pop[0];
            int curX = pop[1];
            if (map[curY][curX] == 'P') {
                person++;
            }
            for (int i = 0; i < 4; i++) {
                int newY = curY + dy[i];
                int newX = curX + dx[i];
                if (0 <= newX && newX < map[0].length && 0 <= newY && newY < map.length && map[newY][newX] != 'X' && !visited[newY][newX]) {
                    queue.add(new int[] {newY, newX});
                    visited[newY][newX] = true;
                }
            }
        }
        if (person == 0) {
            System.out.println("TT");
        } else {
            System.out.println(person);
        }
    }
}
