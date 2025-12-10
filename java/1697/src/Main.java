import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(bfs(a, b));
    }

    public static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int n = 0;
        while (!queue.isEmpty()) {
            n = queue.remove();
            if (n == end) {
                return visited[n];
            }
            if (n - 1 >= 0 && visited[n - 1] == 0) {
                visited[n - 1] = visited[n] + 1;
                queue.add(n - 1);
            }
            if (n + 1 < visited.length && visited[n + 1] == 0) {
                visited[n + 1] = visited[n] + 1;
                queue.add(n + 1);
            }
            if (n * 2 < visited.length && visited[n * 2] == 0){
                visited[n * 2] = visited[n] + 1;
                queue.add(n * 2);
            }
        }
        return -1;
    }
}