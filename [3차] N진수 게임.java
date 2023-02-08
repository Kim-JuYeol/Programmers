import java.util.*;

class Solution 
{
    public String solution(int n, int t, int m, int p) 
    {
        String answer = "";
        int num = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAnswer = new StringBuilder();
        while(true)
        {
            int temp = num;
            StringBuilder sbTemp = new StringBuilder();
            while(true)
            {
                int decimal = temp % n;
                StringBuilder alph = new StringBuilder();
                if(decimal >= 10)
                {
                    if(decimal == 10)
                        sbTemp.insert(0,"A");
                    if(decimal == 11)
                        sbTemp.insert(0,"B");
                    if(decimal == 12)
                        sbTemp.insert(0,"C");
                    if(decimal == 13)
                        sbTemp.insert(0,"D");
                    if(decimal == 14)
                        sbTemp.insert(0,"E");
                    if(decimal == 15)
                        sbTemp.insert(0,"F");
                }
                else
                    sbTemp.insert(0, decimal);
                temp /= n;
                if(temp == 0)
                    break;
            }
            sb.append(sbTemp);
            if(sb.length() >= t*m)
                break;
            num++;
        }
        String serial = sb.toString();
        for(int i=0; i<t; i++)
        {
            int idx = p-1 + (i*m);
            sbAnswer.append(serial.charAt(idx));
        }
        answer = sbAnswer.toString();
        return answer;
    }
}