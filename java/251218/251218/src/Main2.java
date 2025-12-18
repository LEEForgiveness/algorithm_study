import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int input = Integer.parseInt(bufferedReader.readLine());
        result = input / 5 + input / 25 + input / 125;
        System.out.println(result);
    }
}
