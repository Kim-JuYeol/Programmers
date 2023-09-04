import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        HashMap<String, String> musics =  new HashMap<>();
        HashMap<String, Integer> musicsTime = new HashMap<>();
        HashMap<String, Integer> musicsStart = new HashMap<>();
        m=convert(m);
        for(int i=0; i<musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            info[3] = convert(info[3]);
            StringBuilder melody = new StringBuilder();
            int time = 0;
            
            //재생시간 계산 시간이 넘어가지 않는 경우
            if(info[0].substring(0,2).equals(info[1].substring(0,2))){
                time = Integer.parseInt(info[1].substring(3)) - Integer.parseInt(info[0].substring(3));
            }// 시간이 넘어가는 경우
            else{
                int diff = Integer.parseInt(info[1].substring(0,2)) - Integer.parseInt(info[0].substring(0,2));
                diff--;
                time += diff*60;
                time += 60 - Integer.parseInt(info[0].substring(3));
                time += Integer.parseInt(info[1].substring(3));
            }
            // 재생시간동안 나온 멜로디
            for(int j=0; j<time; j++){
                melody.append(info[3].charAt(j % info[3].length()));
            }
            musics.put(melody.toString(), info[2]);
            musicsStart.put(melody.toString(), Integer.parseInt(info[0].replaceAll(":", "")));
        }
        Set<String> melodies = musics.keySet();
        ArrayList<String> answerList = new ArrayList<>();
        int answerTime = 0;
        int idx = 2400;
        for(String key: melodies){
            if(key.contains(m)){
                if(answerTime < key.length()){
                    answerTime = key.length();
                    answerList.add(key);
                    idx = musicsStart.get(key);
                    answer = musics.get(key);
                    continue;
                }
            }
        }
        //먼저 입력된 음악 고르기
        for(int i=0; i<answerList.size(); i++){
            if((answerTime == (answerList.get(i).length())) && (musicsStart.get(answerList.get(i)) < idx)){
                answer = musics.get(answerList.get(i));
            }
        }
        return answer.equals("") ? "(None)" : answer;
    }
    
    //마지막에 String.contains를 활용하기위한 변환
    String convert(String m){
        m = m.replaceAll("A#", "H");
        m = m.replaceAll("C#", "I");
        m = m.replaceAll("D#", "J");
        m = m.replaceAll("F#", "K");
        m = m.replaceAll("G#", "L");
        return m;
    }
}