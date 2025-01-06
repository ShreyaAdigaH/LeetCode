class Solution {
    public int[] minOperations(String boxes) {
     int[] moves = new int[boxes.length()];

        int balls = 0, move = 0;
        for (int i = 0; i < boxes.length(); i++) {
            moves[i] = move;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            move += balls;
        }

        balls = 0;
        move = 0;
        for (int i = boxes.length() - 1; i >= 0; i--) {
            moves[i] += move;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            move += balls;
        }

        return moves;
    }
}