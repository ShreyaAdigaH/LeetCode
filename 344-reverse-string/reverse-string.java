class Solution {
    public void reverseString(char[] s) {
        char temp;

        for (int index = 0; index < s.length / 2; index++) {
            temp = s[index];
            s[index] = s[s.length - 1 - index];
            s[s.length - 1 - index] = temp;
        }
    }
}