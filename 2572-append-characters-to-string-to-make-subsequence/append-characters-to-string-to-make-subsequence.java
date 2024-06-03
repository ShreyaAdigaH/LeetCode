class Solution {
    public int appendCharacters(String s, String t) {
           if(s.equals(t))
            return 0;
            
 int tLength = t.length();
        int sLength = s.length();
        int tIndex = 0;
        int sIndex = 0;
        while(tIndex < tLength && sIndex < sLength) {
            if(s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            sIndex++;
        }
        return tLength - tIndex;
    }
}