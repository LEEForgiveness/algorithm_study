import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sequence = Integer.parseInt(st.nextToken());
            List<int[]> queue = new ArrayList<>();
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                queue.add(new int[] {j, Integer.parseInt(st.nextToken())});
            }

            queue = sort(queue);

            for (int[] l : queue){
                System.out.println(Arrays.toString(l));
            }
        }
    }
    static List<int[]> sort(List<int[]> queue){
        List<int[]> newList = new ArrayList<>();
        queue.sort(((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        }));
        if (queue.size() == 1) {
            return queue;
        }
        int next = queue.get(0)[0];
        int nextValue = queue.get(0)[1];
        for (int i = 1; i < queue.size(); i++) {
            if (next < queue.get(i)[0]) {
                next = queue.get(i)[0];
            } else {

            }
        }

        return queue;
    }
}
