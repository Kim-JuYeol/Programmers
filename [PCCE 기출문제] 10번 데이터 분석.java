import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> exts = new HashMap<>();
        ArrayList<Integer> selectedIdx = new ArrayList<>();
        
        exts.put("code", 0);
        exts.put("date", 1);
        exts.put("maximum", 2);
        exts.put("remain", 3);
        // val_ext보다 작은 데이터 인덱스 추출
        for(int i=0; i<data.length; i++){
            if(data[i][exts.get(ext)] < val_ext){
                selectedIdx.add(i);
            }
        }
        // 추출된 데이터에서 버블정렬로 정렬
        for(int i=1; i<selectedIdx.size(); i++){
            for(int j=0; j < selectedIdx.size() - i; j++){
                if(data[selectedIdx.get(j)][exts.get(sort_by)] > data[selectedIdx.get(j+1)][exts.get(sort_by)]){
                    int temp = selectedIdx.get(j);
                    selectedIdx.set(j, selectedIdx.get(j+1));
                    selectedIdx.set(j+1, temp);
                }
            }
        }
        
        int[][] answer = new int[selectedIdx.size()][4];
        // 정답 배열에 삽입
        for(int i=0; i<selectedIdx.size(); i++){
            for(int j=0; j<4; j++){
                answer[i][j] = data[selectedIdx.get(i)][j];
            }
        }
        
        return answer;
    }
}