// 31 ^ 1 % 1234567891
// 31 ^ 2 % 1234567891 = (31 % 1234567891 * 31 % 1234567891) % 1234567891
// 31 ^ 3 % 1234567891 = (31 ^ 2 % 1234567891 * 31 % 1234567891) % 1234567891

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bf.readLine());
        char[] chars = bf.readLine().toCharArray();
        long result = 0;
        long moduler = 1;
        for (int i = 0; i < chars.length; i++) {
            int numericValue = chars[i] - 'a' + 1;
            result = (result + (numericValue * moduler % 1234567891)) % 1234567891;
            moduler = (moduler * (31 % 1234567891)) % 1234567891 ;
        }
        System.out.println(result);
    }
}