import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int n, result;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        result = 0;
        visited = new int[n];
        getQueens(0);
        System.out.println(result);
    }

    static void getQueens(int depth){
        if (depth == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            visited[depth] = i;
            if (possible(depth)) {
                getQueens(depth + 1);
            }
        }
    }

    static boolean possible(int depth){
        for (int i = 0; i < depth; i++) {
            if (visited[i] == visited[depth]) {
                return false;
            } else if (Math.abs(visited[i] - visited[depth]) == Math.abs(i - depth)) {
                return false;
            }
        }
        return true;
    }
}
