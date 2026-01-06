import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] lans = new long[k];
        for(int i = 0; i < k; i++){
            lans[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(lans);
        long min = 0;
        long max = lans[k - 1] + 1;
        long mid = 0;
        while (min < max){
            mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < k; i++) {
                count += lans[i] / mid;
            }
            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max - 1);
    }
}
