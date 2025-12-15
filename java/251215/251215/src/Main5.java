import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        List<Integer> primeNumberList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(primeNumber(number)){
                primeNumberList.add(number);
            }
        }
        System.out.println(primeNumberList.size());
    }

    static boolean primeNumber(int number){
        if(number == 1){
            return false;
        }

        for (int i = 2; i <= number; i++) {
            if (number != i && number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
