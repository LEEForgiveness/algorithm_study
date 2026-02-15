import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int INF = 100000;
    static int[] dist;
    static boolean[] visited;
    static int n;
    static int m;

    static class Node implements Comparable<Node>{
        int end;
        int value;

        public Node(int end, int value){
            this.end = end;
            this.value = value;
        }


        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        graph = new int[n + 1][n + 1];
        dist = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[start][end] = Math.min(graph[start][end], value);
            graph[end][start] = Math.min(graph[end][start], value);
        }

        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        visited[start] = true;
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            System.out.println(poll.end);
            System.out.println(poll.value);
            for (int i = 1; i <= n; i++) {
                dist[i] = Math.min(dist[i], graph[poll.end][i] + poll.value);
                if (!visited[i]) {
                    queue.add(new Node(i, graph[poll.end][i]));
                    visited[i] = true;
                }
            }
            System.out.println(Arrays.toString(dist));
        }

        return dist[end];
    }
}
