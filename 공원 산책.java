class Solution {
    int idxR = 0;
    int idxC = 0;
    String[] parkCopy;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        parkCopy = park;
        boolean check = true;
        //시작지점찾기
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j)=='S'){
                    idxR = i;
                    idxC = j;
                    check = false;
                    break;
                }
            }
            if(!check){
                break;
            }
        }
        
        for(int i=0; i<routes.length; i++){
            String[] route = routes[i].split(" ");
            if(check(route[0], Integer.parseInt(route[1]))){
                parkCopy[idxR] = parkCopy[idxR].substring(0, idxC) + "S" + parkCopy[idxR].substring(idxC + 1);
            }
        }
        //답 추출
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    answer[0]=i;
                    answer[1]=j;
                    return answer;
                }
            }
        }
        return answer;
    }
    
    boolean check(String direction, int distance){
        if(direction.equals("E")){
            if((idxC+distance) > (parkCopy[0].length() -1)){
                return false;
            }
            for(int i=1; i<=distance; i++){
                if(parkCopy[idxR].charAt(idxC+i)=='X'){
                    return false;
                }
            }
            parkCopy[idxR] = parkCopy[idxR].replaceAll("S", "O");
            idxC+=distance;
            return true;
        }
        else if(direction.equals("S")){
            if((idxR+distance) > (parkCopy.length -1)){
                return false;
            }
            for(int i=1; i<=distance; i++){
                if(parkCopy[idxR+i].charAt(idxC)=='X'){
                    return false;
                }
            }
            parkCopy[idxR] = parkCopy[idxR].replaceAll("S", "O");
            idxR+=distance;
            return true;
        }
        else if(direction.equals("W")){
            if((idxC-distance) < (0)){
                return false;
            }
            for(int i=1; i<=distance; i++){
                if(parkCopy[idxR].charAt(idxC-i)=='X'){
                    return false;
                }
            }
            parkCopy[idxR] = parkCopy[idxR].replaceAll("S", "O");
            idxC-=distance;
            return true;
        }
        else if(direction.equals("N")){
             if((idxR-distance) < (0)){
                return false;
            }
            for(int i=1; i<=distance; i++){
                if(parkCopy[idxR-i].charAt(idxC)=='X'){
                    return false;
                }
            }
            parkCopy[idxR] = parkCopy[idxR].replaceAll("S", "O");
            idxR-=distance;
            return true;
        }
        return false;
    }
    
    
}