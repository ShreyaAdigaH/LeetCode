class Solution {
    public boolean hasAlternatingBits(int n) {
        while (n > 0) {

            if ((((n & 1) ^ (n >> 1)) & 1) != 1) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }
}

// (n & 1) ^ (n >> 1) -- if it has alternating bits then number and number when left shifted 1 times should be different
//                    -- in that case XORing the 2 numbers should give us 1
// (((n & 1) ^ (n >> 1)) & 1) -- after XORing read the last bit using & operator