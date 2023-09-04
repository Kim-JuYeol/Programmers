import java.util.*;

class Solution 
{
    public int solution(String word) 
    {
        int answer = 0;
        int[] list = {781, 156, 31, 6 , 1};
        HashMap<Character, Integer> alpMap = new HashMap<>();
        alpMap.put('A', 0);
        alpMap.put('E', 1);
        alpMap.put('I', 2);
        alpMap.put('O', 3);
        alpMap.put('U', 4);
        for(int i=0; i<word.length(); i++)
        {
            answer += list[i] * alpMap.get(word.charAt(i));
        }
        answer += word.length();
        return answer;
    }
    
}