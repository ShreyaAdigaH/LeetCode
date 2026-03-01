#include <algorithm>
class Solution {
public:
    int minPartitions(string n) {
        int max = 0;
        for(char c : n) {
            int num = c - '0';
            max = std::max(num, max);
        }
        return max;
    }
};