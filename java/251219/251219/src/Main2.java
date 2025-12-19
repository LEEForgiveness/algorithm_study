import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());

        int[] list = new int[end + 1];
        for (int i = 2; i <= end; i++) {
            list[i] = i;
        }

        for (int i = 2; i <= end; i++) {
            for (int j = 2; j <= end / i; j++) {
                if (list[i * j] == 0) {
                    continue;
                }
                list[i*j] = 0;
            }
        }

        System.out.println(Arrays.toString(list));

        for (int i = 0; i < list.length; i++) {
            if(list[i] != 0 && start<= list[i]){
                stringBuilder.append(list[i]).append("\n");
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
