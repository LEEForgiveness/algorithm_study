class Solution {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skillTree: skill_trees){
            skillTree = skillTree.replaceAll("[^"+skill+"]","");
//            System.out.println(skillTree);
            boolean impossible = false;
            for(int i = 0; i < skillTree.length(); i++){
                if(skill.charAt(i) != skillTree.charAt(i)) {
                    impossible = true;
                    break;
                }
            }

            if(!impossible){
                answer++;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }
}