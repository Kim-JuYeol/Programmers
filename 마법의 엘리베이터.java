import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        String fullNumber = Integer.toString(storey);
        int power = 0;
        int length = fullNumber.length();
        for(int i = fullNumber.length() -1; i>=0; i--){
            int number = Character.getNumericValue(fullNumber.charAt(i));
            if(number > 5 ){
                storey += (10 - number) * (int)(Math.pow(10, power));
                fullNumber = Integer.toString(storey);
                answer += (10 - number);
            }
            else if(number == 5 && (i != 0) && (Character.getNumericValue(fullNumber.charAt(i-1))) == 5 ){
                storey += (10 - number) * (int)(Math.pow(10, power));
                fullNumber = Integer.toString(storey);
                answer += (10 - number);
            }
            else if(number == 5 && (i != 0) && (Character.getNumericValue(fullNumber.charAt(i-1))) == 9 ){
                storey += (10 - number) * (int)(Math.pow(10, power));
                fullNumber = Integer.toString(storey);
                answer += (10 - number);
            }
            else{
                storey -= (number) * (int)(Math.pow(10, power));
                fullNumber = Integer.toString(storey);
                answer += (number);
            }
            if (length != fullNumber.length()){
                length = fullNumber.length();
                i++;
            }
            power++;
        }
        
        return answer;
    }
}