class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,0};
        int length = 1000000;
        int end = 0;
        int total = sequence[0];
        
        for(int i=0; i<sequence.length; i++){
            
            while(total < k){
                end++;
                if(end == sequence.length){
                    break;
                }
                total += sequence[end];
            }
            if(end == sequence.length){
                    break;
                }
            if(total == k && length > (end-i)){
                answer[0] = i;
                answer[1] = end;
                length = end - i;
                total -= sequence[i];
            }
            else if(total > k || total == k ){
                total -= sequence[i];
            }
        }
        return answer;
    }
}