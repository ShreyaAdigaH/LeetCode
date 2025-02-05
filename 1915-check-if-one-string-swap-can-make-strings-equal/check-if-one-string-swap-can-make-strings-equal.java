class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
         int mismatch = 0;

        if(s1.length() != s2.length()) {
            return false;
        }

        int firstInd = 0;
        int secInd = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                mismatch++;
                if(mismatch > 2) {
                    return false;
                }
                if(mismatch == 1) {
                    firstInd = i;
                } else if(mismatch == 2){
                    secInd = i;
                }
            }
        }
        return             s1.charAt(firstInd) == s2.charAt(secInd) &&
            s1.charAt(secInd) == s2.charAt(firstInd);
    }
}