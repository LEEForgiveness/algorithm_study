class Solution {
    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] video = video_len.split(":");
        int videoTime = Integer.parseInt(video[0]) * 60 + Integer.parseInt(video[1]);
        String[] time = pos.split(":");
        int posTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        String[] opStart = op_start.split(":");
        int opStartTime = Integer.parseInt(opStart[0]) * 60 + Integer.parseInt(opStart[1]);
        String[] opEnd = op_end.split(":");
        int opEndTime = Integer.parseInt(opEnd[0]) * 60 + Integer.parseInt(opEnd[1]);

        if(opStartTime <= posTime && posTime <= opEndTime){
            posTime = opEndTime;
        }

        for(String c : commands){
            if(opStartTime <= posTime && posTime <= opEndTime){
                posTime = opEndTime;
            }
            if(c.equals("next")){
                posTime += 10;
                if(posTime >= videoTime){
                    posTime = videoTime;
                }
                System.out.println(posTime);
            }
            else {
                posTime -= 10;
                if(posTime <= 0){
                    posTime = 0;
                }
                System.out.println(posTime);
            }
        }

        if(opStartTime <= posTime && posTime <= opEndTime){
            posTime = opEndTime;
        }

        answer = String.format("%02d:%02d", (posTime/60), (posTime % 60));

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.solution("34:33", "13:00", "00:55", "02:55", new String[] {"next", "prev"}));
        System.out.println(Solution.solution("10:55", "00:05", "00:15", "06:55", new String[] {"prev", "next", "next"}));
    }
}