class Solution {
    public int numberOfWays(String corridor) {
        char[] corr = corridor.toCharArray();

        long ways = 1;
        int seatCount = 0;
        int prevSeatIdx = -1;
        for (int i = corridor.length() - 1; i >= 0; i--) {
            if (corr[i] == 'P')
                continue;
            //executed only when seat [s] is found
            if (seatCount == 1)  //if second seat is found then update the index of previous seat index of the seat already found to 1
                prevSeatIdx = i;
            else if (prevSeatIdx > 0) // if previous seat index is not the beginning of the corridor seat
                ways = (ways * (prevSeatIdx - i)) % 1_000_000_007L; 
            seatCount ^= 1; //seat count is 1 when second seat is found from the end and 0 when first seat is found
        }

        return (prevSeatIdx < 0 || seatCount != 0) ? 0 : (int)ways;

    }
}