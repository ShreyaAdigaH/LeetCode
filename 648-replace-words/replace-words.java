class Solution {
    Trie root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Trie();

        for (String word : dictionary) {
            constructTries(word);
        }
        StringBuilder result = new StringBuilder();
        String[] input = sentence.split(" ");
        for (String word : input) {
            result.append(searchPrefixInTrie(word));
            result.append(" ");
        }
        return result.toString().trim();
    }

    public String searchPrefixInTrie(String word) {
        Trie node = root;
        char[] letters = word.toCharArray();
        for (int index = 0; index < letters.length; index++) {
            int letter = letters[index] - 'a';
            if (node.children[letter] == null) {
                return word;
            }
            if (node.children[letter].isEnd) {
                return word.substring(0, index + 1);
            }
            node = node.children[letter];
        }
        return word;
    }

    public void constructTries(String word) {
        Trie node = root; // have one common root for all the words in dictionary.

        char[] letters = word.toCharArray();
        for (char letter : letters) {
            int character = letter - 'a';
            if (node.children[character] == null) { // check if current node has a child representing given letter
                node.children[character] = new Trie(); // if not add a Trie node for that character
            }
            node = node.children[character];
        }
        node.isEnd = true;
    }
}

public class Trie {
    public Trie[] children;
    public boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}