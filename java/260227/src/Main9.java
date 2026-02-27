import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] alphabet = new int[26];
        for (int i = 0; i < n; i++) {
            char[] firstName= bf.readLine().toCharArray();
            alphabet[firstName[0] - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] >= 5) {
                sb.append((char)(i + 'a'));
            }
        }
        if (sb.length() == 0) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
