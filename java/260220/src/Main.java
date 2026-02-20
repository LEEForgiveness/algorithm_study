import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n + 1];
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            if (dp.get(dp.size() - 1) < arr[i]) {
                dp.add(arr[i]);
            } else {
                int index = 1;
                for (int j = 0; j < dp.size(); j++) {
                    System.out.println(dp.get(j));
                    if (arr[i] <= dp.get(j)) {
                        index = j;
                        break;
                    }
                }
                dp.set(index, arr[i]);
            }
            System.out.println(dp);
        }
        System.out.println(dp.size() - 1);
    }
}
