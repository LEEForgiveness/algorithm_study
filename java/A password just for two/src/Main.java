//a -> 5칸 b,c,d,e,f -> c,e,f,g,h
//u -> 5칸 v,w,x,y,z -> v,x,y,z,a
//a는 97, z는 122 u는 117인데 117 < skip < 123

//a에서 20 -> u 117 -> 10 127 - 26 101은 e
class Solution {
    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for(int j = 0; j < index; j++){
                c += 1;
                if (c > 'z'){
                    c -= 26;
                }
                if (skip.contains(String.valueOf(c))){
                    j--;
                }
            }
            answer.append(c);
        }

        return answer.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution("aukks", "wbqd", 5));
        System.out.println(Solution.solution("z","a",1));
        System.out.println(Solution.solution("a", "bcdefghijk", 20));
        System.out.println(Solution.solution("bcdefghijklmnopqrstuvwxyz", "a", 1));
        System.out.println(Solution.solution("z", "abcdefghij", 20));

        //z 122 -> 20이동 a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t -> t -> 142 - 26 116 97 <= skip.char <= 116
        //10개 있음 그러면 142 + 10 152 - 26 126 100
    }
}