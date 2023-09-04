import java.util.*;
class Solution 
{
    static int answer = 0;
    public int solution(int m, int n, String[] board) 
    {
        char[][] board2D = new char[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                board2D[i][j] = board[i].charAt(j);
        while(true)
        {
            if(!erase(m,n,board2D))
                break;
        }
        return answer;
    }
    public boolean erase(int m, int n, char[][] board2D)
    {
        int[][] check = new int[m][n];
        boolean flag = false;
        for(int i=0; i<m-1; i++)
        {
            for(int j=0; j<n-1; j++)
            {
                char temp = board2D[i][j];
                if(temp ==' ')
                    continue;
                if((temp == board2D[i][j+1]) && (temp == board2D[i+1][j+1]) && (temp == board2D[i+1][j]))
                {
                    check[i][j] = 1;
                    check[i+1][j+1] = 1;
                    check[i][j+1] = 1;
                    check[i+1][j] = 1;
                    flag = true;
                }
            }
        }
        if(!flag)
            return false;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(check[i][j] == 1)
                {
                    answer++;
                    for(int k=i; k>=0; k--)
                    {
                        if(k==0)
                            board2D[k][j] = ' ';
                        else
                            board2D[k][j] = board2D[k-1][j];
                    }
                }
            }
        }
        return true;
    }
    public void print(char[][] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }
}