import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int white = 0;
    static int blue = 0;
//    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] pictures = new int[n][n];

        for (int i = 0; i < n; i++) {
            pictures[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            System.out.println(Arrays.toString(pictures[i]));
        }

        makePaper(pictures, n, new int[] {0, 0}, new int[] {n - 1, n - 1});
        System.out.println(white);
        System.out.println(blue);
    }



    static void makePaper(int[][] pictures, int n, int[] start, int[] end){
        boolean isBlue = true;
        boolean isWhite = true;
        for (int i = start[0]; i <= end[0]; i++) {
            for (int j = start[1]; j <= end[1]; j++) {
                if (pictures[i][j] == 1) {
                    isWhite = false;
                } else {
                    isBlue = false;
                }
            }
        }
//        System.out.println("count: " + count);
//        System.out.println("start: " + Arrays.toString(start) + " end: " + Arrays.toString(end));
//        System.out.println("isWhite: " + isWhite + " isBlue: " + isBlue);
//        System.out.println("-----------------------------------------------");

        if (!isWhite && !isBlue) {
//            count++;
            int midY = (start[0] + end[0]) / 2;
            int midX = (start[1] + end[1]) / 2;
            makePaper(pictures, n / 2, new int[] {start[0], start[1]}, new int[] {midY, midX});
            makePaper(pictures, n / 2, new int[] {start[0], midX + 1}, new int[] {midY, end[1]});
            makePaper(pictures, n / 2, new int[] {midY + 1, start[1]}, new int[] {end[0], midX});
            makePaper(pictures, n / 2, new int[] {midY + 1, midX + 1}, new int[] {end[0], end[1]});
        } else {
            if (isWhite) {
                white++;
            }
            if (isBlue) {
                blue++;
            }
        }
    }
}
