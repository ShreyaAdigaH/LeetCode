class Solution {
    public String reorderSpaces(String text) {
        int spacesCount = 0;
        int wordsCount = 0;
        String[] words = new String[51];
        int wordsIndex = 0;
        for (int index = 0; index < text.length(); index++) {
            StringBuilder word = new StringBuilder();
            while (index < text.length() && text.charAt(index) != ' ') {
                word.append(text.charAt(index));
                index++;
            }
            if (!word.isEmpty()) {
                wordsCount++;
                words[wordsIndex++] = String.valueOf(word);
            }
            if (index != text.length())
                spacesCount++;
        }
        if(wordsCount == 1) {
                if(spacesCount == 0)
                    return words[0];
                else {
                    int count = 1;
                    StringBuilder spaces = new StringBuilder();
                    while(count++ <= spacesCount)
                        spaces.append(' ');
                    return words[0] + spaces;
                }
            }
        wordsIndex = 0;
        int equalSpace = spacesCount / (wordsCount - 1);
        int extraSpace = spacesCount % (wordsCount - 1);

        StringBuilder spaceBWWords = new StringBuilder();
        StringBuilder endSpace = new StringBuilder();

        int wordSpaceCount = 1;
        while (wordSpaceCount++ <= equalSpace) {
            spaceBWWords.append(' ');
        }

        int endSpaceCount = 1;

        while (endSpaceCount++ <= extraSpace) {
            endSpace.append(' ');
        }

        StringBuilder result = new StringBuilder();

        while (words[wordsIndex + 1] != null) {
            result.append(words[wordsIndex]).append(spaceBWWords);
            wordsIndex++;
        }
        result.append(words[wordsIndex]).append(endSpace);

        return result.toString();
    }
}