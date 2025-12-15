import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int result = 0;
        for (int i = 1; i < N; i++) {
            int total = i;
            List<String> numbers = List.of(String.valueOf(i).split(""));
            for (int j = 0; j < numbers.size(); j++) {
                total += Integer.parseInt(numbers.get(j));
            }
            if(total == N){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
