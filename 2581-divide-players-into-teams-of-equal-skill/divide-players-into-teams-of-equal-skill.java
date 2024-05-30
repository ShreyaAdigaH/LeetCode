class Solution {
    public long dividePlayers(int[] skills) {
                Arrays.sort(skills);
        int matchedSkillScore = skills[0] + skills[skills.length - 1];
        long score = 0;

        for(int index = 0; index < skills.length / 2; index++) {
            if(skills[index] + skills[skills.length - 1 - index] == matchedSkillScore) {
                score += ((long) skills[index] * skills[skills.length - 1 - index]);
            } else {
                return -1;
            }
        }
        return score;
    }
}