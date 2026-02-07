class Solution {
public:
    int minimumDeletions(string s) {
        int n = s.length();

        vector<int> a_count(n, 0);
        vector<int> b_count(n, 0);

        // calculate prefix b

        int b_s = 0;
        for(int i = 0; i < n; i++) {
            b_count[i] = b_s;
            if(s[i] == 'b') 
                b_s++;
        }

        int a_s = 0;

        for(int i = n - 1; i >= 0; i--) {
            a_count[i] = a_s;
            if(s[i] == 'a') 
                a_s++;
        }

        int minOps = n;

        for(int i = 0; i < n; i++) {
            minOps = min(minOps, a_count[i] + b_count[i]);
        }

        return minOps;
    }
};