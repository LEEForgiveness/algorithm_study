import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
class Solution {

    public static List<Integer> solution(int[] answers) {
        int[] score = {0, 0, 0};
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (first[i % 5] == answers[i]) {
                score[0] += 1;
            }
            if (second[i % 8] == answers[i]) {
                score[1] += 1;
            }
            if (third[i % 10] == answers[i]) {
                score[2] += 1;
            }
        }

        int max = Arrays.stream(score).max().getAsInt();
        System.out.println(max);

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                answer.add(i + 1);
            }
        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(Solution.solution(new int[]{1, 2, 3, 4, 5}));
        System.out.println(Solution.solution(new int[]{1, 3, 2, 4, 2}));
    }
}