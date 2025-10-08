class Solution {
 
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
          Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int spellStrength = spells[i];

            long minPotionStrength = (success + spellStrength - 1) / spellStrength;

            int index = binarySearch(potions, minPotionStrength);

            result[i] = m - index;
        }

        return result;
        
    }


    public int binarySearch(int[] potions, long target) {
        int left = 0;
        int right = potions.length - 1;
        int ans = potions.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}