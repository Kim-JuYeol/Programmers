class Solution 
{
    static int answer = 0;
    static int target = 0;
    public int solution(int[] numbers, int t) 
    {
        target = t;
        dfs(numbers,0,0);
        return answer;
    }
    static int dfs(int[] numbers, int sum, int count)
    {
        if(numbers.length == count)
        {
            if(target == sum)
                answer++;
            return 0;
        }
        dfs(numbers, sum + numbers[count], count+1);
        dfs(numbers, sum - numbers[count], count+1);
        return 0;
    }
}