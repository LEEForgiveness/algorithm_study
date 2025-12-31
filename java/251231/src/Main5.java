import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> visited1 = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }

        for (Integer key: map.keySet()){
            System.out.println("key: " + key + " value: " + map.get(key));
        }
        dfs(map, start, visited1);
        System.out.println(visited1);
        System.out.println(bfs(map, start).toString());
    }

    static void dfs(Map<Integer, List<Integer>> map, int start, List<Integer> visited1){
        visited1.add(start);
        for (int i: map.get(start)){
            if(!visited1.contains(i)){
                dfs(map, i, visited1);
            }
        }
    }

    static List<Integer> bfs(Map<Integer, List<Integer>> map, int start){
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            visited.add(current);
            for (int i: map.get(current)){
                if(!visited.contains(i) && !queue.contains(i)){
                    queue.add(i);
                }
            }
        }
        return visited;
    }
}
