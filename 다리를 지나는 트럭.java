import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; 
        int total = 0; // 현재 다리에있는 차량 무게함
        int idx = 0; // 다음에 다리에 올라올 차량 인덱스
        int passed_idx = 0; // 가장 앞차 인덱스
        
        HashMap<Integer, Integer> onBridge = new HashMap<>(); // 현재 다리상황 차량idx, 다리에 올라온뒤 지난 시간
        
        while(true){
            //다리에 차량을 올릴수있으면 올림
            if((idx < truck_weights.length) && ((total+truck_weights[idx]) <= weight)){
                total+=truck_weights[idx];
                onBridge.put(idx, 0);
                idx++;
            }
            Set<Integer> keySet = onBridge.keySet();
            //다리에 올라온뒤 지속된 시간++
            for (Integer key : keySet){
                onBridge.put(key, onBridge.get(key) +1);
            }
            // 다리에 차량이 없으면 break
            if(onBridge.size() == 0){
                break;
            }
            // 다리를 건넌 차량이 있으면 map에서 제거
            if(onBridge.get(passed_idx) == bridge_length){
                total-= truck_weights[passed_idx];
                onBridge.remove(passed_idx);
                passed_idx++;
            }
            answer++;
            
        }
        //마지막 차량이 건넌뒤 1초++
        answer++;
        return answer;
    }
}