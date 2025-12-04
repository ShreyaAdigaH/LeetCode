class Solution {
    public int countCollisions(String directions) {
        int flag = -1;
        int ans = 0;
        for(char c : directions.toCharArray()) {
            if(c == 'R') {
                // collision possibilities queued
                if(flag >= 0) {
                    flag++;
                } else {
                    flag = 1;
                }
            } else if(c == 'L') { //collision can happen only when you encounter either L or S
                if(flag >= 0) {
                    ans += (flag + 1);
                    flag = 0; // conversion to stationary object for next left moving vehicle
                }
            } else {
                if(flag > 0) { // collision can happen only for moving object with stationary object and not with another stationary object (flag == 0)
                ans += flag;
                }
                flag = 0;
            }
        }
        return ans;
    }
}