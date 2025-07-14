class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int p = 0;
        int t = 0;
        int matches = 0;

        while (p < players.length && t < trainers.length) {
            if (players[p] <= trainers[t]) {
                matches++;
                p++;
                t++;
            } else {
                t++;
            }
        }
        return matches;
    }
}
