class Solution 
{
    int solution(int[][] land) 
    {
        int answer = 0;
        int[][] answers = new int[land.length][4];
        for(int i=0; i<4; i++)
            answers[0][i] = land[0][i];
        for(int i=1; i<land.length; i++)
        {
            for(int j=0; j<land[0].length; j++)
            {
                for(int k=0; k<land[0].length; k++)
                {
                    if(k==j)
                        continue;
                    int temp = answers[i-1][k] + land[i][j];
                    if(answers[i][j] < temp)
                        answers[i][j] = temp;
                }
            }
        }
        for(int i=0; i<4; i++)
            if(answer < answers[land.length-1][i])
                answer = answers[land.length-1][i];
        return answer;
    }
}