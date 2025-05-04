class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotationsTop = check(tops[0], tops, bottoms);
        int rotationsBottom = check(bottoms[0], tops, bottoms);

        if (rotationsTop == -1 && rotationsBottom == -1) {
            return -1;
        } else if (rotationsTop == -1) {
            return rotationsBottom;
        } else if (rotationsBottom == -1) {
            return rotationsTop;
        } else {
            return Math.min(rotationsTop, rotationsBottom);
        }
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotateTop = 0;
        int rotateBottom = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            } else if (tops[i] != target) {
                rotateTop++;
            } else if (bottoms[i] != target) {
                rotateBottom++;
            }
        }
        return Math.min(rotateTop, rotateBottom);
    }
}
