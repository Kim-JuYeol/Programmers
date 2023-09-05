import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answerList = new ArrayList<>();
        String[] dateDetailToday = today.split("\\.");
        HashMap <String, Integer> termTable = new HashMap<>(); 
        for(int i=0; i<terms.length; i++){
            String[] temp = terms[i].split(" ");
            termTable.put(temp[0], Integer.parseInt(temp[1]));
        }
        for(int i=0; i<privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            String[] dateDetailPrivacy = temp[0].split("\\.");
            int expiredMonth = Integer.parseInt(dateDetailPrivacy[1]) + termTable.get(temp[1]);
            while(expiredMonth > 12){
                dateDetailPrivacy[0] = Integer.toString(Integer.parseInt(dateDetailPrivacy[0]) + 1);
                expiredMonth -= 12;
            }
            if(Integer.parseInt(dateDetailPrivacy[0]) < Integer.parseInt(dateDetailToday[0])){
                answerList.add(i+1);
                continue;
            }
            else if((Integer.parseInt(dateDetailPrivacy[0]) == Integer.parseInt(dateDetailToday[0])) && (expiredMonth < Integer.parseInt(dateDetailToday[1]))){
                answerList.add(i+1);
                continue;
            }
            else if((Integer.parseInt(dateDetailPrivacy[0]) == Integer.parseInt(dateDetailToday[0])) && (expiredMonth == Integer.parseInt(dateDetailToday[1])) && (Integer.parseInt(dateDetailToday[2]) > Integer.parseInt(dateDetailPrivacy[2]) - 1)){
                answerList.add(i+1);
                continue;
            }
        }
        
        return answerList;
    }
}