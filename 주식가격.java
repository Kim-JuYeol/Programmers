import java.util.*;
class Solution {
    public int[] solution(int[] prices) 
    {
        int[] answer = new int[prices.length];
        Queue<Integer> stock = new LinkedList<>();
        for(int temp: prices)
            stock.add(temp);
        for(int i=0; i<prices.length; i++)
        {
            int head = stock.poll();
            for(int j=i+1; j<prices.length; j++)
            {
                if(head > prices[j])
                {
                    answer[i] = j-i;
                    break;
                }
                if(j == prices.length -1)
                    answer[i] =j-i;
            }
        }
        return answer;
    }
}