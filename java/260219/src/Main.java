import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int v;
    static int e;
    static List<Node>[] map;
    static boolean[] visited;
    static int[] arr;

    static int INF = 2000000000;

    static class Node implements Comparable<Node>{
        int start;
        int value;

        public Node(int start, int value){
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
        StringTokenizer st = new StringTokenizer(bf.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(bf.readLine());

        map = new List[v + 1];
        visited = new boolean[v + 1];
        arr = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            map[i] = new ArrayList<>();
            arr[i] = INF;
        }

        arr[k] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map[startNode].add(new Node(endNode, value));
        }

        dijkstra(k);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            visited[curNode.start] = true;
            for (int i = 0; i < map[curNode.start].size(); i++) {
                Node next = map[curNode.start].get(i);
                if (!visited[next.start] && arr[next.start] > map[curNode.start].get(i).value + curNode.value) {
                    arr[next.start] = map[curNode.start].get(i).value + curNode.value;
                    pq.add(new Node(next.start, arr[next.start]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (arr[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(arr[i]);
            }
        }
    }
}
