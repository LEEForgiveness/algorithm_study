import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            Queue<int[]> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                queue.add(new int[] {j, Integer.parseInt(st.nextToken())});
            }
            int count = 0;

            while (true){
                int[] front = queue.poll();
                boolean check = true;

                for(int[] list: queue){
                    if(front[1] < list[1]){
                        check = false;
                        break;
                    }
                }
                if (check){
                    count++;
                    if (front[0] == m) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.add(front);
                }

            }
        }
    }
}
