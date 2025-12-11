import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        String[] genres2 = {"hiphop", "classic", "pop", "classic", "classic", "pop", "hiphop"};
        int[] plays2 = {2000, 500, 600, 150, 800, 2500, 2000};
        solution(genres, plays);
        solution(genres2, plays2);
    }
    static List<Integer> solution(String[] genres, int[] plays){
        Map<String, Integer> genreTotalMap = new HashMap<>();
        Map<String, List<int[]>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++){
            genreTotalMap.put(genres[i], genreTotalMap.getOrDefault(genres[i],0) + plays[i]);
            if(!genreMap.containsKey(genres[i])){
                List<int[]> list = new ArrayList<>();
                list.add(new int[] {i, plays[i]});
                genreMap.put(genres[i], list);
            } else {
                genreMap.get(genres[i]).add(new int[] {i, plays[i]});
            }
        }
        System.out.println(genreTotalMap.toString());
        genreMap.forEach((genreKey, dataList) -> {
            System.out.println("\n[장르] Key: **" + genreKey + "**");
            System.out.print("  [데이터] Value: [");

            // List<int[]>의 각 int[] 요소를 람다를 사용하여 처리
            dataList.forEach(intArray -> {
                // int[] 배열을 Arrays.toString()으로 문자열 변환
                System.out.print(Arrays.toString(intArray) + " ");
            });
            System.out.println("]");
        });

        List<String> keySet = new ArrayList<>(genreTotalMap.keySet());
        keySet.sort((o1, o2) -> genreTotalMap.get(o2).compareTo(genreTotalMap.get(o1)));

        List<Integer> result = new ArrayList<>();
        for(String key: keySet){
            List<int[]> list = genreMap.get(key);
            list.sort((a, b) -> {
                if(b[1] != a[1]){
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            });

            int count = 0;
            while (count < 2){
                result.add(list.get(count)[0]);
                count++;
            }

            System.out.println(result.toString());
        }

        return result;
    }

}