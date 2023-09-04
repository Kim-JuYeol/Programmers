import java.util.*;

class Solution 
{
    public int solution(String dirs) 
    {
        int answer = 0;
        ArrayList<String> coordinates = new ArrayList<>();
        String coordinate = "00";
        int x = 0;
        int y = 0;
        for(int i=0; i<dirs.length(); i++)
        {
            StringBuilder temp = new StringBuilder(coordinate);
            String past = coordinate;
            switch(dirs.charAt(i))
            {
                case 'L':
                    if(x == -5)
                        continue;
                    x -= 1;
                    break;
                case 'R':
                    if(x == 5)
                        continue;
                    x += 1;
                    break;
                case 'D':
                    if(y == -5)
                        continue;
                    y -= 1;
                    break;
                case 'U':
                    if(y == 5)
                        continue;
                    y += 1;
                    break;
            }
            temp.append(x);
            temp.append(y);
            coordinate = "" + x+y;
            StringBuilder temp2 = new StringBuilder(coordinate);
            temp2.append(past);
            if(!coordinates.contains(temp.toString()))
                answer++;
            coordinates.add(temp.toString());
            coordinates.add(temp2.toString());
        }
        return answer;
    }
}