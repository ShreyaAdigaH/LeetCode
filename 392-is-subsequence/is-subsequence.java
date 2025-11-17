class Solution {
    public boolean isSubsequence(String s, String t) {
        String small;
        String big;

        if(t.isEmpty() && !s.isEmpty()) {
            return false;
        }

     

        int sp = 0;
        int bp = 0;

        while(sp < s.length() && bp < t.length()) {
            if(s.charAt(sp) == t.charAt(bp)) {
                sp++;
                bp++;
            } else {
                bp++;
            }
        }

        return sp == s.length();
    }
}