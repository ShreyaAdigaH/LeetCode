class Solution {
    public int[] constructRectangle(int area) {
 int length = 1;
        int[] result = new int[2];
        result[0] = area;
        result[1] = 1;

        for(; length * length <= area; length++) {
            if(area % length == 0) {
                int breadth = area / length;
                if(Math.abs(result[0] - result[1]) > length - breadth) {
                    result[0] = breadth;
                    result[1] = length;
                }

            }
        }
        return result;
    }
}