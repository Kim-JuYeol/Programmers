import java.util.*;
class Solution 
{
    public String[] solution(String[] files) 
    {
        String[] answer = new String[files.length];
        String[] heads = new String[files.length];
        String[] numbers = new String[files.length];
        int[] sortIdx = new int[files.length];
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<files.length; i++)
        {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            int idx = 0;
            // head
            for(int j=0; j<files[i].length(); j++)
            {
                if(Character.isDigit(files[i].charAt(j)))
                {
                    idx = j;
                    break;
                }
                else
                    head.append(files[i].charAt(j));
            }
            // number
            for(int j=idx; j<files[i].length(); j++)
            {
                if(!Character.isDigit(files[i].charAt(j)))
                {
                    idx = j;
                    break;
                }
                else
                    number.append(files[i].charAt(j));
            }
            heads[i] = head.toString();
            numbers[i] = number.toString();
            sortIdx[i] = i;
        }
        for(int i=0; i<heads.length; i++)
        {
            for(int j=0; j<heads.length-1; j++)
            {
                if(heads[j].toLowerCase().compareTo(heads[j+1].toLowerCase()) > 0)
                {
                    String tempStr = heads[j];
                    int tempIdx = sortIdx[j];
                    heads[j] = heads[j+1];
                    heads[j+1] = tempStr;
                    sortIdx[j] = sortIdx[j+1];
                    sortIdx[j+1] = tempIdx;
                }
            }
        }
        TreeMap<String, ArrayList<String>> sortMap = new TreeMap<>();
        for(int i=0; i<numbers.length; i++)
        {
            if(!sortMap.containsKey(heads[i].toLowerCase()))
            {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(numbers[sortIdx[i]]);
                sortMap.put(heads[i].toLowerCase(), temp);
                queue.add(heads[i].toLowerCase());
            }
            else
            {
                ArrayList<String> temp = new ArrayList<>(sortMap.get(heads[i].toLowerCase()));
                temp.add(numbers[sortIdx[i]]);
                sortMap.put(heads[i].toLowerCase(), temp);
            }
        }
        int idx = 0;
        for(int i=0; i<sortMap.size(); i++)
        {
            String key = queue.poll();
            ArrayList<String> temp = new ArrayList<>(sortMap.get(key));
            for(int j=0; j<temp.size(); j++)
            {
                for(int k=0; k<temp.size()-1; k++)
                {
                    if(Integer.parseInt(temp.get(k)) > Integer.parseInt(temp.get(k+1)))
                    {
                        String tempStr = temp.get(k);
                        int tempIdx = sortIdx[idx+k];
                        temp.set(k, temp.get(k+1));
                        temp.set(k+1, tempStr);
                        sortIdx[idx+k] = sortIdx[idx+k+1];
                        sortIdx[idx+k+1] = tempIdx;
                    }
                }
            }
            sortMap.put(key, temp);
            idx += temp.size();
        }
        for(int i=0; i<answer.length; i++)
            answer[i] = files[sortIdx[i]];
        return answer;
    }
}