import java.util.*;

class Solution 
{
    int max = 99;
    
    public int solution(String begin, String target, String[] words) 
    {
        int answer = 0;
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> startList = new ArrayList<>();
        if(!wordsList.contains(target))
            return 0;
        for(int i=0; i<wordsList.size(); i++)
        {
            String temp = wordsList.get(i);
            int count = 0;
            for(int j=0; j<begin.length(); j++)
                if(temp.charAt(j)==begin.charAt(j))
                    count++;
            if(count==begin.length() - 1)
                startList.add(temp);
        }
         for(int i=0; i<startList.size(); i++)
        {
             ArrayList<String> temp = new ArrayList<>(wordsList);
             String start = startList.get(i);
             temp.remove(start);
             DFS(temp, start, target, 0);
        }
        answer = max;
        return answer;
    }
    public void DFS(ArrayList<String> wordsList, String begin, String target, int count)
    {
        count++;
        if(target.equals(begin) && max > count)
            max = count;
        for(int i=0; i<wordsList.size(); i++)
        {
            String tempStr = wordsList.get(i);
            int c = 0;
            for(int j=0; j<begin.length(); j++)
                if(tempStr.charAt(j) == begin.charAt(j))
                    c++;
            if(c==begin.length() -1)
            {
                ArrayList<String> tempList = new ArrayList<>(wordsList);
                tempList.remove(tempStr);
                DFS(tempList, tempStr, target, count);
            }
        }
    }
}