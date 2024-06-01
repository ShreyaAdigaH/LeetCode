class Solution {
    public String mergeAlternately(String s1, String s2) {
        StringBuilder mergedString = new StringBuilder();
        int pointer;
        for (pointer = 0; pointer < s1.length() && pointer < s2.length(); pointer++) {
            mergedString.append(s1.charAt(pointer)).append(s2.charAt(pointer));
        }

        if (s1.length() != s2.length()) {
            String longerString = s1.length() > s2.length() ? s1 : s2;
            mergedString.append(longerString.substring(pointer));
        }
        return mergedString.toString();
    }
}