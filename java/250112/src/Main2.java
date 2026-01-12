import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] dx = {1, -1, 1, 1, 1, -1, 1, -3, 1, -1, 1, 1, 1, -1, 1, 1};
        int[] dy = {0, 1, 0, -1, 0, 1, 0, 1, 0, 1, 0, -1, 0, -1, 0, -3};
        int startX = 0;
        int startY = 0;
        int count = 0;

        while(startX != c || startY != r){
            System.out.println("startX: " + startX + " startY: " + startY);
            int index = count % 4;
            startX = startX + dx[index];
            startY = startY + dy[index];
            count++;
        }

        System.out.println(count);
    }
}
