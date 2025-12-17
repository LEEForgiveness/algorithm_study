// 666 -> 1666-> 2666-> 3666 -> 4666 -> 5666-> 6660(6) -> 6661 -> 6662 -> 6663 -> 6664 -> 6665 -> 6666 ->
// 6667 -> 6668 -> 6669(15) -> 7666 -> 8666 -> 9666 -> 10666 -> 11666 -> 12666-> 13666 -> 14666 ->
// 15666 -> 16660(25) -> 16661 -> 16662 -> 16663 -> 16664 -> 16665 -> 16666 -> 16667 -> 16668 -> 16669 ->
// 17666 -> 18666 -> 19666 -> 20666 -> 21666 -> 22666 -> 23666 -> 24666 -> 25666 -> 26661 ~ 26669

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        solve2(N);
    }
    static void solve2(int number){
        int index = 0;
        int i = 666;
        while (true) {
            if (Integer.toString(i).contains("666")) {
                index++;
//                System.out.println("index:" + index + ", result: " + i);
            }
            if (index == number) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
