import java.util.ArrayList;
import java.util.HashMap;


class Solution {
    public String[] solution(String[] record) 
    {
        ArrayList<String> systems = new ArrayList<>();
        HashMap<String, String>Userlist = new HashMap<>();
        for(int i=0; i<record.length; i++)
        {
            if(record[i].charAt(0) == 'E')
            {
                String[] msg = record[i].split(" ");
                String system = "";
                Userlist.put(msg[1], msg[2]);
                system = msg[1] +"님이 들어왔습니다.";
                systems.add(system);
            }
            else if(record[i].charAt(0) == 'L')
            {
                String[] msg = record[i].split(" ");
                String system = "";
                system = msg[1] +"님이 나갔습니다.";
                systems.add(system);
            }
            else
            {
                String[] msg = record[i].split(" ");
                Userlist.put(msg[1], msg[2]);
            }
        }
        for(int i=0; i<systems.size(); i++)
        {
            systems.set(i, systems.get(i).replace(systems.get(i).substring(0, systems.get(i).indexOf("님")), Userlist.get(systems.get(i).substring(0, systems.get(i).indexOf("님")))));
        }
        String[] answer = systems.toArray(new String[systems.size()]);
        return answer;
    }
}