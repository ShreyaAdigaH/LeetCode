class Solution {
    public String addSpaces(String s, int[] spaces) {
           char[] res = new char[s.length() + spaces.length];

        int p2 = 0;
        int p1 = 0;

        for(int i = 0; i < s.length(); i++) {
            if(p2 < spaces.length && i == spaces[p2]) {
                res[p1++] = ' ';
                res[p1++] = s.charAt(i);
                p2++;
            } else {
                res[p1++] = s.charAt(i);
            }

        }
        return String.valueOf(res);
    }
}