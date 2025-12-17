import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<int[]> xy = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] numbers = Arrays.stream(bufferedReader
                .readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            xy.add(numbers);
        }
        xy.sort((a, b) ->{
            if(a[0] != b[0]){
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int[] p : xy) {
            sb.append(p[0]).append(' ').append(p[1]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
