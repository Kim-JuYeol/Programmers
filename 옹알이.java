class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0; i<babbling.length; i++){
            String temp = babbling[i];
            int length = 0;
            if(temp.contains("aya")){
                length +=3;
            }
            if(temp.contains("ye")){
                length +=2;
            }
            if(temp.contains("woo")){
                length +=3;
            }
            if(temp.contains("ma")){
                length +=2;
            }
            if(length == babbling[i].length()){
                answer++;
            }
        }
        return answer;
    }
}