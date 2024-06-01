class Solution {
    public int scoreOfString(String s) {
        int strLength = s.length();
        int sum = 0;
        for (int index = 0; index < strLength - 1; index++) {
            sum = sum + Math.abs((s.charAt(index) - s.charAt(index + 1)));
        }
        return sum;
    }
}