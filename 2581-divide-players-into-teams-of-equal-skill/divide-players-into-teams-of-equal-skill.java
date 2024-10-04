class Solution {
    public long dividePlayers(int[] skills) {
        int totalPlayers = skills.length;
        int[] skillsFreq = new int[1001];
        int totalSkill = 0;
        int teams = totalPlayers / 2;
        long totalChemistry = 0;

        for (int skill : skills) {
            totalSkill += skill;
            skillsFreq[skill]++;
        }

        if (totalSkill % teams != 0) {
            return -1;
        }

        int eachTeamSkill = totalSkill / teams;

        for (int playerSkill : skills) {
            int otherPlayerSkill = eachTeamSkill - playerSkill;

            if (skillsFreq[otherPlayerSkill] == 0) {
                return -1;
            }

            totalChemistry += (long) playerSkill * (long) otherPlayerSkill;
            skillsFreq[otherPlayerSkill]--;
        }
        return  (totalChemistry / 2);
    }
}