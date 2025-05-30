import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int w = Integer.parseInt(stringTokenizer.nextToken());
            int h = Integer.parseInt(stringTokenizer.nextToken());

            if(w == 0 && h == 0){
                break;
            }

            System.out.println(problem(w, h, bufferedReader));
        }
    }

    static int problem(int w, int h, BufferedReader bufferedReader) throws IOException {

        int[][] map = new int[h][w];
        int[][] visited = new int[h][w];
        int count = 0;

        for (int i = 0; i < h; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    count += dfs(i, j, map, visited);
                }
            }
        }
        return count;
    }

    static int dfs(int x, int y, int[][] map, int[][] visited) {
        visited[x][y] = 1;
        for (int i = 0; i < dx.length; i++) {
            for (int j = 0; j < dy.length; j++) {
                if (x + dx[i] >= 0 && x + dx[i] < visited.length && y + dy[j] >= 0
                    && y + dy[j] < visited[0].length && visited[x + dx[i]][y + dy[j]] == 0
                    && map[x + dx[i]][y + dy[j]] == 1) {
                    dfs(x + dx[i], y + dy[j], map, visited);
                }
            }
        }

        return 1;
    }
}