class Solution {
    public int[] plusOne(int[] digits) {
       StringBuilder result = new StringBuilder();
        int sum = digits[digits.length - 1] + 1;
        int carry = sum / 10;
        result.append(sum % 10);

        for(int idx = digits.length - 2; idx >= 0; idx--) {
           sum = digits[idx] + carry;
           carry = sum / 10;
           result.append(sum % 10);
        }

        if(carry > 0) {
            result.append(carry);
        }
        char[] resultString = result.toString().toCharArray();
        int[] resultArray = new int[resultString.length];
        for(int idx = resultString.length - 1; idx >= 0; idx--) {
            resultArray[resultString.length - 1 - idx] = resultString[idx] - '0';
        }

        return resultArray;  
    }
}