class Solution {
    public String maximumNumber(String num, int[] change) {
         //change the digit from front

        char[] numChar = num.toCharArray();
        boolean startRep = false;
        for (int i = 0; i < numChar.length; i++) {
            int digit = numChar[i] - '0'; 
            if (change[digit] > digit || (startRep && change[digit] == digit)) {
                // Start replacing
                startRep = true;
                numChar[i] = (char) (change[digit] + '0'); 
            } else if (startRep) {
                break;
            }
        }
        return new String(numChar);
    }
}