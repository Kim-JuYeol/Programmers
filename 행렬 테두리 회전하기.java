import java.util.*;

class Solution 
{
    public int[] solution(int rows, int columns, int[][] queries)
    {
        int[][] matrix = new int[rows][columns];
        int[] answer = new int[queries.length];
        for(int i=1; i<=rows; i++)
            for(int j=1; j<=columns; j++)
                matrix[i-1][j-1] = columns*(i-1) + j;
        for(int i=0; i<queries.length; i++)
        {
            int rotateCount = (queries[i][2] - queries[i][0] +1) * (queries[i][3] - queries[i][1]+1) - ((queries[i][2] - queries[i][0] -1)*(queries[i][3] - queries[i][1]-1));
            Stack<Integer> temp = new Stack<>();
            ArrayList<Integer> rotate = new ArrayList<>();
            
            for(int j=queries[i][1]-1; j<queries[i][3]; j++)
            {
                rotate.add(matrix[queries[i][0]-1][j]);
                temp.push(matrix[queries[i][0]-1][j]);
            }
            for(int j=queries[i][0]; j<queries[i][2]; j++)
            {
                rotate.add(matrix[j][queries[i][3]-1]);
                temp.push(matrix[j][queries[i][3]-1]);
            }
            for(int j=queries[i][3]-2; j>=queries[i][1]-1; j--)
            {
                rotate.add(matrix[queries[i][2]-1][j]);
                temp.push(matrix[queries[i][2]-1][j]);
            }
            for(int j=queries[i][2]-2; j>queries[i][0]-1; j--)
            {
                rotate.add(matrix[j][queries[i][1]-1]);
                temp.push(matrix[j][queries[i][1]-1]);
            }
            answer[i] = Collections.min(rotate);
            if(i+1 == queries.length)
                break;
            for(int j=queries[i][0] - 1; j<queries[i][2]; j++)
                matrix[j][queries[i][1]-1] = temp.pop();
            for(int j=queries[i][1]; j<queries[i][3]; j++)
                matrix[queries[i][2]-1][j] = temp.pop();
            for(int j=queries[i][2]-2; j>=queries[i][0]-1; j--)
                matrix[j][queries[i][3]-1] = temp.pop();
            for(int j=queries[i][3]-2; j>=queries[i][1]; j--)
                matrix[queries[i][0]-1][j] = temp.pop();
        }
        return answer;
    }
}