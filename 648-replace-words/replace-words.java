class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> dict = new HashSet<>(dictionary);
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < sentence.length(); index++) {
            StringBuilder temp = new StringBuilder();
            boolean wordFormed = false;
            while (index < sentence.length() && sentence.charAt(index) != ' ') {
                if (!wordFormed) {
                    temp.append(sentence.charAt(index));
                    if (dict.contains(temp.toString())) {

                        wordFormed = true;
                    }
                }
                index++;
            }
            result.append(temp);
            if (index < sentence.length()) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}