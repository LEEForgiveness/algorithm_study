import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        List<int[]> coordinates = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int[] coordinate = new int[2];
            coordinate[0] = Integer.parseInt(st.nextToken());
            coordinate[1] = Integer.parseInt(st.nextToken());
            coordinates.add(coordinate);
        }
        coordinates.sort((a, b) -> {
            if(a[1] != b[1]){
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int[] p : coordinates) {
            sb.append(p[0]).append(' ').append(p[1]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
