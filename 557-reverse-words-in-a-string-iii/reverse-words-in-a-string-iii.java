class Solution {
    public String reverseWords(String s) {
        char[] reversed = new char[s.length()];
        int sLength = s.length();
        for (int index = 0; index < sLength; index++) {
            int lp = index;
            while (index < sLength && s.charAt(index) != ' ') {
                index++;
            }
            int rp = index - 1;

            while (lp <= rp) {
                reversed[lp] = s.charAt(rp);
                reversed[rp] = s.charAt(lp);
                lp++;
                rp--;
            }
            if (index < sLength) {
                reversed[index] = ' ';
            }
        }
        return String.valueOf(reversed);
    }
}