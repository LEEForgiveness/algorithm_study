import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(number);
        for (int i = 0; i < number.length; i++) {
            bufferedWriter.write(number[i] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
