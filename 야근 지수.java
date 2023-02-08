import java.util.*;

class Solution 
{
    public long solution(int n, int[] works) 
    {
        long answer = 0;
        int count = 1;
        while(n>0)
        {
            Arrays.sort(works);
            if(works[0] == works[works.length-1])
                break;
            if(check(works, n, count))
            {
                int target = works[works.length-1-count];
                int differ = works[works.length-1] - target;
                for(int i=0; i<count; i++)
                {
                    works[works.length-1-i] -= differ;
                    n-=differ;
                }
            }
            else
                break;
            count++;
        }
        while(n>0)
        {
            Arrays.sort(works);
            works[works.length - 1]--;
            n--;
        }
        Arrays.sort(works);
        if(works[0] < 0)
            return answer;
        for(int i=0; i<works.length; i++)
            answer += works[i] * works[i];
        return answer;
    }
    public boolean check(int[] works, int n, int count)
    {
        int target = works[works.length-1-count];
        int differ = works[works.length-count] - target;
        if((differ * count) > n)
            return false;
        else
            return true;
    }
}