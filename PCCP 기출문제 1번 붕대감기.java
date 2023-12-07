class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int limit = attacks[attacks.length-1][0];
        int castingTime = bandage[0];
        int heal = bandage[1];
        int successHeal = bandage[2];
        int attackIdx = 0;
        int casting = 0;
        int hp = health;
        for(int i=1; i<=limit; i++){
            if(attacks[attackIdx][0] == i)
            {
                casting = 0;
                hp -= attacks[attackIdx][1];
                if(hp <= 0){
                    return -1;
                }
                attackIdx ++;
            }
            else
            {
                casting++;
                hp += heal;
                if(castingTime == casting){
                    hp += successHeal;
                    casting = 0;
                }
                if(hp > health){
                    hp = health;
                }
            }
                
        }
        return hp;
    }
}