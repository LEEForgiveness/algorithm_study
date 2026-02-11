import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4 {
    static int[] items;
    static int[][] maps;
    static int[] dist;

    static class Node implements Comparable<Node> {
        int position;
        int weight;

        Node(int position, int weight){
            this.position = position;
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        maps = new int[n + 1][n + 1];
        dist = new int[n + 1];
        st = new StringTokenizer(bf.readLine());
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            items[i] = input;
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                maps[i][j] = 16;
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            maps[start][end] = len;
            maps[end][start] = len;
        }
        for (int i = 1; i <= n; i++) {
            max = Math.max(dijkstra(n, m, i), max);
        }
        System.out.println(max);
    }

    static int dijkstra(int n, int m, int start){
        int totalItems = 0;
        Arrays.fill(dist, 16);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int position = curNode.position;;
            int weight = curNode.weight;
            for (int i = 1; i <= n; i++) {
                if (dist[i] > weight + maps[position][i]) {
                    dist[i] = weight + maps[position][i];
                    queue.add(new Node(i, dist[i]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                totalItems += items[i];
            }
        }
        return totalItems;
    }
}
