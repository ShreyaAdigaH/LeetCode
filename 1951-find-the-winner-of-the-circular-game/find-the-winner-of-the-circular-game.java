class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> players = new ArrayList<>();

        for (int player = 1; player <= n; player++) {
            players.add(player);
        }

        int current_player = 0;
        while (players.size() > 1) {
            current_player = (current_player + (k - 1)) % n;
            players.remove(current_player);
            n--;
        }
        return players.get(0);
    }
}