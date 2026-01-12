import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> nodes = new HashMap<>();
        int[] visited = new int[node + 1];
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (!nodes.containsKey(start)) {
                List<Integer> input = new ArrayList<>();
                input.add(end);
                nodes.put(start, input);
            } else {
                List<Integer> input = nodes.get(start);
                input.add(end);
                nodes.put(start, input);
            }
            if (!nodes.containsKey(end)) {
                List<Integer> input = new ArrayList<>();
                input.add(start);
                nodes.put(end, input);
            } else {
                List<Integer> input = nodes.get(end);
                input.add(start);
                nodes.put(end, input);
            }
        }

        for (Integer i: nodes.keySet()) {
            System.out.println(i + ": " + nodes.get(i).toString());
        }
        int count = 0;
        for (int i = 1; i <= node; i++){
            if (visited[i] == 0) {
                dfs(nodes, visited, i);
                count++;
            }
        }
        System.out.println(Arrays.toString(visited));
        System.out.println(count);
    }

    static void dfs(Map<Integer, List<Integer>> nodes, int[] visited, int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = 1;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            List<Integer> curList = nodes.get(cur);
            if (curList == null) {
                continue;
            }
            for (int i: curList){
                if (visited[i] == 0) {
                    stack.push(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
