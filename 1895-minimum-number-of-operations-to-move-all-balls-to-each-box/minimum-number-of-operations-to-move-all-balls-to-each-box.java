class Solution {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        for (int index = 0; index < boxes.length(); index++) {
            int moves = 0;
            for (int box = 0; box < boxes.length(); box++) {
                if (box != index && boxes.charAt(box) == '1') {
                    moves += Math.abs(index - box);
                }
                result[index] = moves;
            }
        }
        return result;
    }
}