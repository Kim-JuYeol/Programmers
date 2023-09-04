import java.util.*;

class Solution 
{
    public int solution(String[] want, int[] number, String[] discount) 
    {
        int answer = 0;
        ArrayList<String> wants = new ArrayList<>(Arrays.asList(want));
        ArrayList<String> wantNum = new ArrayList<>();
        for(int i=0; i<want.length; i++)
            for(int j=0; j<number[i]; j++)
                wantNum.add(wants.get(i));
        for(int i=0; i<=discount.length - 10; i++)
        {
            ArrayList<String> temp = new ArrayList<>();
            for(int j=i; j<i+10; j++)
            {
                if(!wants.contains(discount[j]))
                    break;
                else
                    temp.add(discount[j]);
            }
            if(temp.size()!=10)
                continue;
            else
            {
                for(int j=0; j<10; j++)
                {
                    if(temp.contains(wantNum.get(j)))
                    {
                        temp.remove(wantNum.get(j));
                    }
                    else
                        break;
                }
            }
            if(temp.size() == 0)
                answer++;
        }
        return answer;
    }
}