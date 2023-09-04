import java.util.*;

class Solution 
{
    public int solution(int[] scoville, int K) 
    {
        PriorityQueue<Integer> scovilleTemp = new PriorityQueue<>();
        int count = 0;
        for(int temp: scoville)
            scovilleTemp.add(temp);
        while(true)
        {
            if((scovilleTemp.size() == 1) && (scovilleTemp.peek() < K))
            {
                count = -1;
                break;
            }
            if(scovilleTemp.peek() >= K)
                break;
            int newScoville = scovilleTemp.poll() + (scovilleTemp.poll() * 2);
            scovilleTemp.add(newScoville);
            count ++;
        }
        System.out.println(scovilleTemp.size());
        int answer = count;
        return answer;
    }
}