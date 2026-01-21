import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] friends = new int[n + 1][n + 1];
        int[] result = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            friends[start][end] = 1;
            friends[end][start] = 1;
        }

        for (int i = 1; i <= n; i++) {
            result[i] = bfs(friends, i);
        }
        int minIndex = 1;
        int min = result[1];
        for (int i = 2; i < result.length; i++) {
            if (min > result[i]) {
                min = result[i];
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }

    static int bfs(int[][] friends, int start){
        boolean[] visited = new boolean[friends[start].length];
        int[] distance = new int[friends[start].length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 1; i < friends[cur].length; i++) {
                if (friends[cur][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    distance[i] = distance[cur] + 1;
                }
            }
        }
        int result = 0;
        for (int i = 1; i < distance.length; i++) {
            result += distance[i];
        }
        return result;
    }
}
