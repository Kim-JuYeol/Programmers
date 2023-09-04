class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int highest = 100;
        int leftest = 100;
        int rightest = 0;
        int lowest = 0;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(i < highest ){
                        highest = i;
                    }
                    if(i > lowest ){
                        lowest = i;
                    }
                    if(j < leftest ){
                        leftest = j;
                    }
                    if(j > rightest ){
                        rightest = j;
                    }
                }
            }
        }
        answer[0] = highest;
        answer[1] = leftest;
        answer[2] = ++lowest;
        answer[3] = ++rightest;
        return answer;
    }
}