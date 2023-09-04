import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack <Integer> assistant = new Stack<>();
        int answer = 0;
        int idx = 0;
        int conv = 1;
        while(true){
            if(order[idx] == conv){
                answer++;
                idx++;
                conv++;
            }
            else if(order[idx] > conv){
                assistant.push(conv);
                conv++;
            }
            else if(assistant.peek() == order[idx]){
                assistant.pop();
                answer++;
                idx++;
            }
            else{
                break;
            }
            
            if(idx==order.length){
                break;
            }
        }
        
        return answer;
    }
}