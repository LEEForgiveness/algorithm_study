import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 10 -> 402 10 / 6 = 1 10 // 6 = 4
// 60 -> 610 60 / 6 = 10 60// 6 = 0
// 59 -> 510 59 / 6 = 9 59 // 6 = 5
// 61 -> 111 61/ 6 = 10 61 // 6 = 1

// 72 -> 1203 72/30 = 2 72 // 30 = 12
// 75 -> 1503 75/30 = 2 72 // 30 = 15
// 90 -> 3003 90/30 = 3 90 // 30 = 0

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int guests = Integer.parseInt(st.nextToken());

            if (guests % height == 0){
                int roomNumber = guests / height;
                int floor = height;
                System.out.println(floor * 100 + roomNumber);
            } else {
                int roomNumber = guests / height + 1;
                int floor = guests % height;
                System.out.println(floor * 100 + roomNumber);
            }
        }
    }
}
