import java.util.*;

class Solution 
{
    public int solution(String skill, String[] skill_trees) 
    {
        int answer = 0;
        ArrayList<Character> skills = new ArrayList<>();
        for(int i=0; i<skill.length(); i++)
            skills.add(skill.charAt(i));
        for(int i=0; i<skill_trees.length; i++)
        {
            String skill_tree = skill_trees[i];
            StringBuilder seq = new StringBuilder();
            for(int j=0; j<skill_tree.length(); j++)
            {
                if(skills.contains(skill_tree.charAt(j)))
                    seq.append(skill_tree.charAt(j));
            }
            if(seq.length() == 0)
            {
                answer++;
                continue;
            }
            int idx;
            for(int j=0; j<seq.length(); j++)
            {
                idx = skill.indexOf(seq.charAt(j));
                if(idx != j)
                    break;
                if(j == seq.length() - 1)
                    answer++;
            }
        }
        return answer;
    }
}