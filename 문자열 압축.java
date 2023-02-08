import java.util.Stack;
import java.util.Vector;

class Solution {
    public int solution(String s) 
    {
        int answer = s.length();
        String compressed = "";
        for(int i=0; i<s.length(); i++)
        {
            Vector<String> splits = new Vector<>();
            Stack<String> overlap = new Stack<>();
            Stack<String> compresser = new Stack<>();
            String rest = s.substring(s.length()-(s.length() % (i+1)), s.length());
            for(int j=0; j<s.length() -i; j+=i+1)
            {
                String a = "";
                for(int k=j; k<j+i+1; k++)
                    a += s.charAt(k);
                splits.add(a);
            }
            splits.add(rest);
            
            for(int j=0; j<splits.size(); j++)
            {
                if(compresser.empty())
                {
                    compresser.push(splits.get(j));
                    overlap.push(splits.get(j));
                    continue;
                }
                if(compresser.peek().equals(splits.get(j)))
                {
                    try
                    {
                        int countInt = Integer.parseInt(overlap.peek());
                        countInt++;
                        String countStr = Integer.toString(countInt);
                        overlap.pop();
                        overlap.push(countStr);
                    }
                    catch(NumberFormatException e)
                    {
                        overlap.push("2");
                    }
                }
                else
                {
                    compresser.push(splits.get(j));
                    overlap.push(splits.get(j));
                }
            }
            String compressedStr = "";
            for(int j=0; j<overlap.size(); j++)
                compressedStr += overlap.get(j);
            if(compressedStr.length() < answer)
                answer = compressedStr.length();
        }
        return answer;
    }
}