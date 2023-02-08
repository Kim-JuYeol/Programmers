import java.util.*;

class Solution 
{
    public int[] solution(int[] fees, String[] records) 
    {
        HashMap<String, String> inTime = new HashMap<>();
        ArrayList <String> leftCar = new ArrayList<>();
        HashMap<String, Integer> stackTime = new HashMap<>();
        for(int i=0; i<records.length; i++)
        {
            String[] record = records[i].split(" ");
            if(record[2].equals("IN"))
            {
                inTime.put(record[1], record[0]);
                if(!stackTime.containsKey(record[1]))
                    stackTime.put(record[1], 0);
                leftCar.add(record[1]);
            }
            else
            {
                leftCar.remove(record[1]);
                String[] time = inTime.get(record[1]).split(":");
                int parkingTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                time = record[0].split(":");
                parkingTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]) - parkingTime; 
                stackTime.put(record[1], stackTime.get(record[1]) + parkingTime);
            }
        }
        for(int i=0; i<leftCar.size(); i++)
        {
            String[] time = inTime.get(leftCar.get(i)).split(":");
            int parkingTime = 1439;
            parkingTime -= Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            stackTime.put(leftCar.get(i), stackTime.get(leftCar.get(i)) + parkingTime);
        }
        Map<String, Integer> sorted = new TreeMap<>(stackTime);
        int i = 0;
        int[] answer = new int[sorted.size()];
        for(String key: sorted.keySet())
        {
            int fee = 0;
            if(sorted.get(key) > fees[0])
                fee = (int)Math.ceil((sorted.get(key) - fees[0]) / (double)fees[2]) * fees[3] + fees[1];
            else
                fee = fees[1];
            answer[i] = fee;
            i++;
        }
        return answer;
    }
}