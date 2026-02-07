class Solution {
public:
    int minimumDeletions(string s) {
       int n = s.length();

       stack<char> charStack;
       int deleteCount = 0;

       for(int i = 0; i < n; i++) {
        if(s[i] == 'b') {
            charStack.push(s[i]);
        } else {
            if(!charStack.empty() && charStack.top() == 'b') {
                charStack.pop();
                deleteCount++;
            }
        }
       }

       return deleteCount;
    }
};