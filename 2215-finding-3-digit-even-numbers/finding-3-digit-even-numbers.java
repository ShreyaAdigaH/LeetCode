class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        List<Integer> result = new ArrayList<>();
        for (int num : digits) {
            freq[num]++;
        }

        for (int i = 1; i <= 9; i++) {
            if (freq[i] == 0) {
                continue;
            }
            freq[i]--;
            for (int j = 0; j <= 9; j++) {
                if (freq[j] == 0) {
                    continue;
                }
                freq[j]--;
                for (int k = 0; k <= 8; k = k + 2) {
                    if (freq[k] == 0) {
                        continue;
                    }
                    freq[k]--;
                    result.add(i * 100 + j * 10 + k);
                    freq[k]++;
                }
                freq[j]++;
            }
            freq[i]++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }

}