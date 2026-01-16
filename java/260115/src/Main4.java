import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        char[][] picture = new char[n][n];
        int[][] visited = new int[n][n];
        char[][] picture2 = new char[n][n];
        int[][] visited2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            picture[i] = bf.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            picture2[i] = picture[i].clone();
            visited2[i] = new int[n];
        }
        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] != 1) {
                    bfs(picture, visited, new int[] { i, j });
                    result[0]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (picture2[i][j] == 'R') {
                    picture2[i][j] = 'G';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited2[i][j] != 1) {
                    bfs(picture2, visited2, new int[] { i, j });
                    result[1]++;
                }
            }
        }
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static void bfs(char[][] picture, int[][] visited, int[] start) {
        int n = picture.length;
        char color = picture[start[0]][start[1]];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newY = cur[0] + dy[i];
                int newX = cur[1] + dx[i];

                if (0 <= newX && newX < n && 0 <= newY && newY < n && visited[newY][newX] != 1
                        && color == picture[newY][newX]) {
                    queue.add(new int[] { newY, newX });
                    visited[newY][newX] = 1;
                }
            }
        }
    }
}
