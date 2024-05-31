class Solution {
    public int[] singleNumber(int[] nums) {
       //calculate the xor of whole array which gives you XOR of 2 distinct numbers we wanted
        int xor = 0;
        for(int num : nums)
            xor = xor ^ num;

        //find out the position in the bit representation of the XORed number where the bit value is 1
        // & operand is used to read a bit in any position of a number
        // Therefore, to read every bit of a number perform bitwise AND operation between every bit and 1
        // To do the above operation keep shifting the bit value 1 until it reaches the end of the binary representation

        int bitPosition = 0;
        while((xor & (1 << bitPosition)) == 0) {
            bitPosition++;
        }
        // th bit in bitPosition is different in two unique numbers present in array as the xor of the respective bit gave value 1

        //now group every numbers in the given array into 2 groups
        //one group where the bit value in bitPosition is 1 and another group where the bit value is 0
        //after completing this step all numbers who has their duplicate value in grouped in the same group
        //and result of XORing the numbers in one group will give 1st unique number and XORing the numbers in 2nd group will give 2nd unique number
        //as the rest of the numbers in group are cancelled out with each other as XOR of same numbers results in 0
        int num1 = 0;
        int num2 = 0;
        for(int num : nums) {
            System.out.println("Value " + (num & (1 << bitPosition)));
            if((num & (1 << bitPosition)) == 0)
                num1 = num1 ^ num;
            else
                num2 = num2 ^ num;
        }

        return new int[] {num1, num2};
 
    }
}