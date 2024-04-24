class Solution {
    public int hammingDistance(int x, int y) {
               int dis = 0;
        int xor = x ^ y;
        for (int count = 0; count <= 32; count++) {
            if (xor % 2 != 0) {
                dis++;
            }
            xor = xor >> 1;
        }

        return dis;
    }
}