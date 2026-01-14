import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<int[]> graph = new ArrayList<>();
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.add(input);
        }
        for (int i = 0; i < n; i++) {
            dfs(graph, result, n, i);
            }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    static void dfs(List<int[]> graph, int[][] result, int n, int start){
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(start)[i] == 1) {
                stack.push(i);
                visited[i] = 1;
                result[start][i] = 1;
            }
        }
        while(!stack.isEmpty()){
            int i = stack.pop();

            for (int j = 0; j < n; j++) {
                if(graph.get(i)[j] == 1 && visited[j] != 1){
                    stack.push(j);
                    result[start][j] = 1;
                    visited[j] = 1;
                }
            }
        }
    }
}
