import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int ladderCount = Integer.parseInt(st.nextToken());
        int snakeCount = Integer.parseInt(st.nextToken());
        int maxKey = 0;
        int max = 0;
        int[] map = new int[101];
        Map<Integer, Integer> move = new HashMap<>();
        for (int i = 0; i < ladderCount; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            move.put(start , end);
        }

        for (int i = 0; i < snakeCount; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            move.put(start, end);
        }

        bfs(move, map);
    }

    static void bfs(Map<Integer, Integer> move, int[] map){
        int start = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 1; i <= 6; i++) {

                if(cur + i > 100){
                    continue;
                }

                if (map[cur + i] == 0) {
                    if (move.containsKey(cur + i)) {
                        queue.add(move.get(cur + i));
                        if (map[move.get(cur + i)] == 0) {
                            map[move.get(cur + i)] = map[cur] + 1;
                        } else {
                            map[move.get(cur + i)] = Math.min(map[cur] + 1, map[move.get(cur + i)]);
                        }
                    } else {
                        queue.add(cur + i);
                        if (map[cur + i] == 0) {
                            map[cur + i] = map[cur] + 1;
                        } else {
                            map[cur + i] = Math.min(map[cur] + 1, map[cur + i]);
                        }
                    }
                }
                if (cur + i == 100) {
                    System.out.println(map[100]);
                    return;
                }
            }
        }
    }
}
