import java.util.*;

class Solution 
{
    static ArrayList<Integer> combs = new ArrayList<>();
    
    public int solution(String numbers) 
    {
        int[] nums = new int[numbers.length()];
        int answer = 0;
        ArrayList<Integer> refinedCombs = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
            nums[i] = Character.getNumericValue(numbers.charAt(i));
        for(int i=1; i<=numbers.length(); i++)
            permut(nums, 0, i);
        for(int i=0; i<combs.size(); i++)
            if(!refinedCombs.contains(combs.get(i)))
                refinedCombs.add(combs.get(i));
         for(int i=0; i<refinedCombs.size(); i++)
             if(isPrime(refinedCombs.get(i)))
                 answer++;
        return answer;
    }
    static boolean isPrime(int num)
    {
        if(num < 2)
            return false;
        for (int i = 2; i<=(int)Math.sqrt(num); i++) 
            if (num % i == 0)
                return false;
        return true;
    }
    static void swap(int[] arr, int depth, int i)
    {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    static void permut(int[] arr, int depth, int r)
    {
        if(depth == r)
        {
            String temp = "";
            for(int i=0; i<r; i++)
            {
                temp += arr[i];
            }
            combs.add(Integer.parseInt(temp));
            return;
        }
        for(int i=depth; i< arr.length; i++)
        {
            swap(arr, depth, i);
            permut(arr, depth+1, r);
            swap(arr, depth, i);
        }
    }
}