import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().split("-");
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            String[] strings1 = strings[i].split("\\+");
            int temp = 0;
            for (int j = 0; j < strings1.length; j++) {
                temp += Integer.parseInt(strings1[j]);
            }
            if (i == 0) {
                result = temp;
            } else {
                result -= temp;
            }
        }
        System.out.println(result);
    }
}
