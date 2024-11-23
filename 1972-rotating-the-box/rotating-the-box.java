class Solution {
    public char[][] rotateTheBox(char[][] box) {
          char[][] res = new char[box[0].length][box.length];
        for(int r = 0; r < box.length; r++) {
            int nxtBlank = box[r].length - 1;
            for(int c = box[0].length - 1; c >= 0; c--) {
                if(box[r][c] == '*') {
                    nxtBlank = c - 1;
                } else if (box[r][c] == '#') {
                    char temp = box[r][nxtBlank];
                    box[r][nxtBlank] = box[r][c];
                    box[r][c] = temp;
                    nxtBlank--;
                }
            }
        }
        for (int r = 0; r < res.length; r++) {
            for (int c = 0; c < res[r].length; c++) {
                res[r][c] = box[box.length - 1 - c][r];
            }
        }
        return res;
    }
}