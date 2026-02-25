import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        bfs(n,k);
        System.out.println(min);
    }

    static void bfs(int start, int end){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curLocation = cur[0];
            int curCount = cur[1];
//            System.out.println(curLocation + ": " + curCount);
//            System.out.println("--------------");
            if (curLocation == end) {
//                System.out.println(curLocation);
                if (curCount < min) {
                    min = curCount;
                }
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0 && curLocation + 1 < 100001 && !visited[curLocation + 1] ) {
                    queue.add(new int[] {curLocation + 1, curCount + 1});
                } else if (i == 1 && curLocation - 1 >= 0 && !visited[curLocation - 1]) {
                    queue.add(new int[] {curLocation - 1, curCount + 1});
                } else if(i == 2 && curLocation * 2 < 100001 && !visited[curLocation * 2]){
                    queue.add(new int[] {curLocation * 2, curCount});
                }
            }
            visited[curLocation] = true;
        }
    }
}
