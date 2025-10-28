class Solution {
    public int numberOfBeams(String[] bank) {
        int lasers = 0;
        int beamCount = 0;
        int prev = lasers;
        for (int i = 0; i < bank.length; i++) {
            int curr = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1')
                    curr += 1;
            }

            if (curr > 0) {
                beamCount += (curr * prev);
                prev = curr;
            }
        }
        return beamCount;
    }
}