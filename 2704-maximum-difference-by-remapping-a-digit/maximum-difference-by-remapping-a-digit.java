class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        String numStrMin = numStr;
        int i = 0;
        while(i < numStr.length() && numStr.charAt(i) == '9') {
            i++;
        }

        if (i < numStr.length()) {
             numStr = numStr.replace(numStr.charAt(i) , '9');
        }
        numStrMin = numStrMin.replace(numStrMin.charAt(0), '0');

        return Integer.valueOf(numStr) - Integer.valueOf(numStrMin);


    }
}