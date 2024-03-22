import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        HashMap<String, Integer> giftPoint = new HashMap<>();
        HashMap<String, Integer> giftReceive = new HashMap<>();
        List<String> giftList = new ArrayList<>(Arrays.asList(gifts));
        List<String> distinctGiftList = new ArrayList<>(Arrays.asList(Arrays.stream(gifts).distinct().toArray(String[]:: new)));
        // 선물지수 해쉬맵 선언, 선물 받을 횟수 해쉬맵 선언
        for(int i=0; i<friends.length; i++){
            giftPoint.put(friends[i], 0);
            giftReceive.put(friends[i], 0);
        }
        
        //선물지수 계산
        for(int i=0; i<gifts.length; i++){
            String[] temp = gifts[i].split(" ");
            giftPoint.replace(temp[0], giftPoint.get(temp[0])+1);
            giftPoint.replace(temp[1], giftPoint.get(temp[1])-1);
        }
        
        //주고받았던 사람들끼리의 경우의수
        for(int i=0; i<distinctGiftList.size(); i++){
            String[] temp = distinctGiftList.get(i).split(" ");
            int cnt = Collections.frequency(giftList,distinctGiftList.get(i));
            int cnt2 = Collections.frequency(giftList, temp[1] + " " + temp[0]);
            
            if(cnt > cnt2)
                giftReceive.replace(temp[0], giftReceive.get(temp[0])+1);
            else if(cnt < cnt2)
                giftReceive.replace(temp[1], giftReceive.get(temp[1])+1);
            else if(cnt == cnt2){
                if(giftPoint.get(temp[0]) > giftPoint.get(temp[1]))
                    giftReceive.replace(temp[0], giftReceive.get(temp[0])+1);
                else if(giftPoint.get(temp[0]) < giftPoint.get(temp[1]))
                    giftReceive.replace(temp[1], giftReceive.get(temp[1])+1);
            }
            distinctGiftList.remove(temp[1] + " " + temp[0]);
        }
        // 주고받지 않았던 사람들끼리의 경우의수
        for(int i=0; i<friends.length-1; i++){
            for(int j=i+1; j<friends.length; j++){
                String comb = friends[i] + " " + friends[j];
                String comb2 = friends[j] + " " + friends[i];
                if(!giftList.contains(comb) && !giftList.contains(comb2)){
                    if(giftPoint.get(friends[i]) > giftPoint.get(friends[j]))
                        giftReceive.replace(friends[i], giftReceive.get(friends[i])+1);
                    else if(giftPoint.get(friends[i]) < giftPoint.get(friends[j]))
                        giftReceive.replace(friends[j], giftReceive.get(friends[j])+1);
                }
            }
        }
        Collection<Integer> values = giftReceive.values();
        answer = Collections.max(values);
        return answer;
    }
}