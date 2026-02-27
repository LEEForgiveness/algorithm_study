import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int count = 0;
        while ((input = bf.readLine()) != null) {
            count++;
        }

        System.out.println(count);
    }
}
