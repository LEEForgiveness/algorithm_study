import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, x;
    static int[][] map;
    static int INF = 1000000;
    static int max = 0;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i <= n; i++) {
            map[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[start][end] = weight;
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        for (int i = 1; i <= n; i++) {
            max = Math.max(map[i][x] + map[x][i], max);
        }

        System.out.println(max);
    }

    static void dijkstra(int start){
        int[] arr = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(arr, INF);
        arr[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            visited[curNode.end] = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[i] > curNode.weight + map[curNode.end][i]) {
                    arr[i] = curNode.weight + map[curNode.end][i];
                    pq.add(new Node(i, arr[i]));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            map[start][i] = Math.min(map[start][i], arr[i]);
        }
    }
}
