class Solution {
    public int hammingDistance(int x, int y) {
                int dis = 0;

        int xor = x ^ y;

        if(xor % 2 != 0) {
            dis++;
        }
        for(int count = 0; count <= 32; count++) {
            xor = xor >> 1;

            if(xor % 2 != 0) {
                dis++;
            }
        }

        return dis;
    }
}