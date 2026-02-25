import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main3 {
    static int n,m;
    static int[][] map;
    static final int INF = 100_000_000;
    static boolean[] visited;
    static int[] arr;
    static int[] visitedArray;

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
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        arr = new int[n + 1];
        visitedArray = new int[n + 1];
        int result = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end], weight);
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start  = Integer.parseInt(st.nextToken());
        int end  = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
        sb.append(arr[end]).append("\n");
        int index = end;
        while(index != start){
            list.add(index);
            result++;
            index = visitedArray[index];
        }
        list.add(start);

        sb.append(list.size()).append("\n");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(arr, INF);
        arr[start] = 0;
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node pollNode = pq.poll();
            int pollNodeEnd = pollNode.end;
            int pollNodeWeight = pollNode.weight;
            visited[pollNodeEnd] = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[i] > pollNodeWeight + map[pollNodeEnd][i]) {
                    arr[i] = pollNodeWeight + map[pollNodeEnd][i];
                    pq.add(new Node(i, arr[i]));
                    visitedArray[i] = pollNodeEnd;
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
//        visitedArray.add(end);
//        System.out.println(Arrays.toString(visitedArray));
    }
}
