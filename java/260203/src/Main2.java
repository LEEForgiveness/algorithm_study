import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static HashSet<Long> visited = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        bfs(a, b);
    }

    static void bfs(long start, long end){
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[] {start, 1});
        visited.add(start);
        while (!queue.isEmpty()){
            long[] cur = queue.poll();
            long curNumber = cur[0];
            long curCount = cur[1];

            if (curNumber == end) {
                System.out.println(curCount);
                return;
            } else {
                if (curNumber * 2 <= end &&!visited.contains(curNumber * 2)) {
                    queue.add(new long[]{curNumber * 2, curCount + 1});
                    visited.add(curNumber * 2);
                }
                if (curNumber * 10 + 1 <= end && !visited.contains(curNumber * 10 + 1)) {
                    queue.add(new long[]{curNumber * 10 + 1, curCount + 1});
                    visited.add(curNumber * 10 + 1);
                }
            }
        }
        System.out.println(-1);
    }
}
