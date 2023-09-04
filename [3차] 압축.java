import java.util.*;

class Solution 
{
    public int[] solution(String str) 
    {
        int idx = 1;
        ArrayList<Integer> tempAns = new ArrayList<>();
        StringBuilder msg = new StringBuilder();
        msg.append(str);
        HashMap<String, Integer> dict = new HashMap<>();
        char word = 'A';
        for(idx = 1; idx<=26; idx++)
        {
            String temp = "" + word;
            dict.put(temp, idx);
            word++;
        }
        int tail = 0;
        while(msg.length()!=0)
        {
            StringBuilder dichek = new StringBuilder(msg.subSequence(0,msg.length()-tail));
            if(dict.containsKey(dichek.toString()))
            {
                tempAns.add(dict.get(dichek.toString()));
                if(msg.length() == msg.length() - tail)
                    break;
                dichek.append(msg.charAt(msg.length()-tail));
                dict.put(dichek.toString(), idx);
                msg.delete(0,msg.length()-tail);
                idx++;
                tail=0;
            }
            else
                tail++;
        }
        idx = 0;
        int[] answer = new int[tempAns.size()];
        for(int temp: tempAns)
            answer[idx++] = temp;
        return answer;
    }
}