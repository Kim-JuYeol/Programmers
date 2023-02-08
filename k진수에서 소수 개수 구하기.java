import java.util.*;

class Solution 
{
    public int solution(long n, long k) 
    {
        int answer = 0;
        ArrayList<String> candidates = new ArrayList<>();
        String number = "";
        while(true)
        {
            number= (n%k) + number;
            n = n/k;
            if(n==0)
                break;
        }
        String temp = "";
        for(int i=0; i<number.length(); i++)
        {
            if(number.charAt(i) != '0')
                temp+=number.charAt(i);
            else
            {
                if(temp.length() == 0)
                    continue;
                if(isPrime(Long.parseLong(temp)))
                    candidates.add(temp);
                temp = "";
            }
        }
        if(temp.length() != 0)
            if(isPrime(Long.parseLong(temp)))
                candidates.add(temp);
        if(candidates.size() == 1)
            return 1;
        for(int i=0; i<candidates.size(); i++)
        {
            if(i == 0)
            {
                int tail = number.indexOf(candidates.get(i)) + candidates.get(i).length();
                if(number.charAt(tail) == '0' && number.indexOf(candidates.get(i)) == 0)
                    answer++;
                number = number.substring(tail);
            }
            else if(i == candidates.size() - 1)
            {
                int head = number.indexOf(candidates.get(i)) - 1;
                if(number.charAt(head) == '0')
                    answer++;
            }
            else
            {
                int head = number.indexOf(candidates.get(i)) - 1;
                int tail = number.indexOf(candidates.get(i)) + candidates.get(i).length();
                if(number.charAt(tail) == '0' && number.charAt(head) == '0')
                    answer++;
                number = number.substring(tail);
            }
        }
        return answer;
    }
    static boolean isPrime(long num)
    {
        if(num == 1)
            return false;
        if(num == 0)
            return false;
         for(int i=2; i<=Math.sqrt(num); i++)
            if(num % i == 0) 
                return false;
        return true;
    }
}