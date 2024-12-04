class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int sp1 = 0;
        int sp2 = 0;

        while (sp1 < str1.length() && sp2 < str2.length()) {
            if (str1.charAt(sp1) == str2.charAt(sp2) || ('a' + (str1.charAt(sp1) - 'a' + 1) % 26) == str2.charAt(sp2)) {
                if (sp2 == str2.length() - 1) {
                    return true;
                }
                sp2++;
            }
            sp1++;
        }
        return false;
    }
}