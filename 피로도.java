import java.util.*;
class Solution 
{
    static ArrayList<String> orders = new ArrayList<>();
    public int solution(int k, int[][] dungeons) 
    {
        int answer = 0;
        int[] arr = new int[dungeons.length];
        for(int i=0; i<dungeons.length; i++)
            arr[i] = i;
        per1(arr, 0, arr.length, arr.length);
        for(int i=0; i<orders.size(); i++)
        {
            int fatigue = k;
            int max = 0;
            for(int j=0; j<dungeons.length; j++)
            {
                 if(fatigue < dungeons[Character.getNumericValue(orders.get(i).charAt(j))][0])
                    break;
                fatigue -= dungeons[Character.getNumericValue(orders.get(i).charAt(j))][1];
                max++;
            }
            if(max == dungeons.length)
            {
                answer = max;
                break;
            }
            if(max > answer)
                answer = max;
        }
        return answer;
    }
    
    static void swap(int[] arr, int depth, int i) 
    {  
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    static void per1(int[] arr, int depth, int n, int r) 
    {
        if(depth == r) 
        {
            StringBuilder order = new StringBuilder();
            for(int temp: arr)
                order.append(temp);
            orders.add(order.toString());
            return;
        }

        for(int i=depth; i<n; i++) 
        {
            swap(arr, depth, i);
            per1(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }
}