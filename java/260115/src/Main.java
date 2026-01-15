import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[i] = input;
        }

        for (int i = 0; i < n; i++) {
            dfs(map, result, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int[][] map, int[][] result, int start){
        int n = map[0].length;
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (map[start][i] == 1) {
                stack.push(i);
                visited[i] = 1;
                result[start][i] = 1;
            }
        }
        while(!stack.isEmpty()){
            int cur = stack.pop();
            for (int i = 0; i < n; i++) {
                if (map[cur][i] == 1 && visited[i] != 1) {
                    stack.push(i);
                    visited[cur] = 1;
                    result[start][i] = 1;
                }
            }
        }
    }
}
