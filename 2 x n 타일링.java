class Solution 
{
    public int solution(int n) 
    {
        int answer = 0;
        int first = 1;
        int second = 2;
        for(int i=0; i<n-2; i++)
        {
            answer = (first + second) % 1000000007;
            first = second;
            second = answer;
        }
        return answer;
    }
}