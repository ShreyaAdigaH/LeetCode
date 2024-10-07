class Solution {
    public int minLength(String s) {
               Stack<Character> charStack = new Stack<>();
        char[] strArray = s.toCharArray();
        for(char c : strArray) {
            charStack.push(c);
            if(charStack.size() >= 2) {
               if((charStack.getLast() == 'B' && charStack.get(charStack.size() - 2) == 'A') ||
                       (charStack.getLast() == 'D' && charStack.get(charStack.size() - 2) == 'C')) {
                   charStack.pop();
                   charStack.pop();
               }
            }
        }
        return charStack.size(); 
    }
}