import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] inputs = new int[N];
        int[] count = new int[N];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());
            inputs[i] = input;
        }
        int average = 0;
        int median = inputs[inputs.length / 2];
        int mode = 0;
        int period = inputs[inputs.length - 1] - inputs[0];
        Arrays.sort(inputs);
        for(int i: inputs){

            average += i;
        }
        average = Math.round((float) average / N);

    }
}
