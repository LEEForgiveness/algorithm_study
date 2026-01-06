import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] trees = new int[k];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < k; i++){
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        long min = 0;
        long max = trees[k - 1];
        long mid = 0;
        long temp = 0;
        while (min < max){
            mid = (max + min) / 2;
            long count = 0;
            for (int i = 0; i < k; i++) {
                long getTree = trees[i] - mid;
                if (getTree <= 0) {
                    count += 0;
                } else {
                    count += getTree;
                }
            }
            System.out.println("max: " + max + " min: " + min + " mid: " + mid + " count: " + count);
            if (count >= n) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        System.out.println(min - 1);
    }
}