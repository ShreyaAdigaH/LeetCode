class Solution {
    int[] parent; 
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // set characters as parent for themseleves
         parent = new int[26];
        StringBuilder result = new StringBuilder(baseStr.length());

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // group directly and transitively equal charecters

        for (int i = 0; i < s1.length(); i++) {
            // grouping by pointing lexicographically smallest parent among parents s1 char and s2 char as the parent for both charecter
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // form resulting string by finding the parent of each charecter of base string
        // lexicographically smallest letter in a group will be having itself as parent

        for (char c : baseStr.toCharArray()) {
            result.append((char) (find(c - 'a') + 'a'));
        }
        return result.toString();
    }

    // find parent (root)
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb)
          return;
        
        if(pa < pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }
}