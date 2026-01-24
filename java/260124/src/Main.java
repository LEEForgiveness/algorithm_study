import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        makeZ((int) Math.pow(2, n), 0, 0, r, c);
    }
    static void makeZ(int size, int y, int x, int r, int c){
        if(size == 1){
            if (y == r && x == c) {
                System.out.println(count);
                System.exit(0);
            }
            count++;
            return;
        }
        if (y <= r && r < y + size && x <= c && c < x + size) {
            int half = size / 2;
            makeZ(half, y, x, r, c);
            makeZ(half, y, x + half, r, c);
            makeZ(half, y + half, x, r, c);
            makeZ(half, y + half, x + half, r, c);
        } else {
            count += size * size;
        }
    }
}
