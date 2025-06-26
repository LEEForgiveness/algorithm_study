import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("정답 = d 현재 풀이 값 =" + findNotRepeatingFirstCharacter("abadabac"));
        System.out.println("정답 = c 현재 풀이 값 =" + findNotRepeatingFirstCharacter("aabbcddd"));
        System.out.println("정답 = _ 현재 풀이 값 =" + findNotRepeatingFirstCharacter("aaaaaaaa"));
    }

    public static Character findNotRepeatingFirstCharacter(String strings) {
        List<Character> alpabets = new ArrayList<>();
        for (int i = 0; i < strings.length(); i++) {
            if(!alpabets.contains(strings.charAt(i))){
                alpabets.add(strings.charAt(i));
                System.out.println(alpabets);
            }
            else {
                alpabets.remove((Character)strings.charAt(i));
                System.out.println(alpabets);
            }
        }

        if(alpabets.isEmpty()){
            return '_';
        }
        else {
            return alpabets.getFirst();
        }
    }
}