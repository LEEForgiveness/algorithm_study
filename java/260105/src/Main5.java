import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while (T --> 0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int inputCount = Integer.parseInt(st.nextToken());
            int[][] cabbageField = new int[n][m];
            int[][] visited = new int[n][m];
            while (inputCount --> 0){
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbageField[y][x] = 1;
            }
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(cabbageField[i]));
//            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(cabbageField[i][j] == 1 && visited[i][j] == 0){
                        result++;
                        dfs(cabbageField, visited, i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void dfs(int[][] cabbageField, int[][] visited, int startY, int startX){
        visited[startY][startX] = 1;
        for (int i = 0; i < 4; i++) {
            int nowX = startX + dx[i];
            int nowY = startY + dy[i];
            if (isCheck(cabbageField, nowX, nowY) && cabbageField[nowY][nowX] == 1 && visited[nowY][nowX] == 0) {
                dfs(cabbageField, visited, nowY, nowX);
            }
        }
    }

    static boolean isCheck(int[][] cabbageField, int nowX, int nowY){
        if(nowX >= 0 && nowX < cabbageField[0].length && nowY >= 0 && nowY < cabbageField.length){
            return true;
        } else {
            return false;
        }
    }
}