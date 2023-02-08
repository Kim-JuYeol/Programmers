class Solution {
    public long solution(int w, int h) 
    {
        Long width = Long.valueOf(w);
        Long height = Long.valueOf(h);
        long big = 0;
        long little = 0;
        long rest = 1;
        if(w >= h)
        {
            big = (long)w;
            little = (long)h;
        }
        else
        {
            big = (long)h;
            little = (long)w;
        }
        while(true)
        {
            rest = big % little ;
            if(rest == 0)
                break;
            big = little;
            little = rest;
        }
        long answer = width*height - (w+h-little);
        return answer;
    }
}