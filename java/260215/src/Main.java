import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[] arr;
    static boolean[] visited;
    static int INF = 100000000;

    static class Node implements Comparable<Node> {
        int start;
        int value;

        Node(int start, int value){
            this.start = start;
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
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        arr =  new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        Arrays.fill(arr, INF);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], value);
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        arr[start] = 0;

        dijkstra(start, end);
    }

    static void dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            visited[curNode.start] = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[i] > curNode.value + map[curNode.start][i]) {
                    arr[i] = curNode.value + map[curNode.start][i];
                    pq.add(new Node(i, arr[i]));
                }
            }
        }

        System.out.println(arr[end]);
    }
}
