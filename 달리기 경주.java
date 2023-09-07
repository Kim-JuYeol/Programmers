import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> nameRankTable = new HashMap<>();
        HashMap<Integer, String> rankNameTable = new HashMap<>();
        // 현재 상태 맵에 업데이트
        for(int i=0; i<players.length; i++){
            nameRankTable.put(players[i], i);
            rankNameTable.put(i, players[i]);
        }
        // 이름이 불릴때마다 현재 상태 업데이트
        for(int i=0; i<callings.length; i++){
            int rank = nameRankTable.get(callings[i]);
            String forePlayer = rankNameTable.get(rank-1);
            nameRankTable.put(callings[i], rank - 1);
            nameRankTable.put(forePlayer, rank);
            rankNameTable.put(rank, forePlayer);
            rankNameTable.put(rank -1 , callings[i]);
        }
        //답을 배열에 담는 과정
        for(int i=0; i<players.length; i++){
            answer[i] = rankNameTable.get(i);
        }
        return answer;
    }
}