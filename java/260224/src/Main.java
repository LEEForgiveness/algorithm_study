import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, checkpoint1, checkpoint2;
    static int[][] map;
    static boolean[] visited;
    static int[] arr;
    static final int INF = 10000000;

    static class Node implements Comparable<Node>{
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
        int e = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        arr = new int[n + 1];
        Arrays.fill(arr, INF);
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map[n1][n2] = value;
            map[n2][n1] = value;
        }
        st = new StringTokenizer(bf.readLine());
        checkpoint1 = Integer.parseInt(st.nextToken());
        checkpoint2 = Integer.parseInt(st.nextToken());

        int v1Tov2Result = 0;
        int v2Tov1Result = 0;
        v1Tov2Result += dijkstra(1, checkpoint1);
        v1Tov2Result += dijkstra(checkpoint1, checkpoint2);
        v1Tov2Result += dijkstra(checkpoint2, n);

        v2Tov1Result += dijkstra(1, checkpoint2);
        v2Tov1Result += dijkstra(checkpoint2, checkpoint1);
        v2Tov1Result += dijkstra(checkpoint1, n);
//        System.out.println(v1Tov2Result);
//        System.out.println(v2Tov1Result);
        if (v2Tov1Result >= INF && v1Tov2Result >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(v1Tov2Result, v2Tov1Result));
    }

    static int dijkstra(int start, int end){
        Arrays.fill(arr, INF);
        Arrays.fill(visited, false);
        arr[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
//            System.out.println("end:" + curNode.end + " weight:" + curNode.weight);
            visited[curNode.end] = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[i] > curNode.weight + map[curNode.end][i]) {
                    arr[i] = curNode.weight + map[curNode.end][i];
                    pq.add(new Node(i, arr[i]));
                }
            }
            visited[curNode.end] = false;
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println("---------------------");
        return arr[end];
    }
}