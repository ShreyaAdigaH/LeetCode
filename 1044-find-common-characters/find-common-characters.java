class Solution {
    public List<String> commonChars(String[] words) {
        int[] baseFreq = new int[26];
        int[] compareFreq;
        List<String> commonLetter = new ArrayList<>();

        for (char c : words[0].toCharArray()) {
            baseFreq[c - 'a']++;
        }

        for (String word : words) {
            compareFreq = new int[26];

            for (char c : word.toCharArray()) {
                compareFreq[c - 'a']++;
            }

            for (int letter = 0; letter < 26; letter++) {
                if (baseFreq[letter] != 0) {
                    if (compareFreq[letter] != 0) {
                        if (baseFreq[letter] > compareFreq[letter]) {
                            baseFreq[letter] = compareFreq[letter];
                        }
                    } else {
                        baseFreq[letter] = 0;
                    }
                }
            }
        }
        for (int letter = 0; letter < 26; letter++) {
            if (baseFreq[letter] != 0) {
                int count = 0;
                while (++count <= baseFreq[letter]) {
                    commonLetter.add(String.valueOf((char) (letter + 'a')));
                }
            }
        }
        return commonLetter;
    }
}