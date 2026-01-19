class Solution {
public:
    int maxSideLength(vector<vector<int>>& mat, int threshold) {
        int m = mat.size();
        int n = mat[0].size();

        // Prefix sum matrix
        vector<vector<int>> pre(m + 1, vector<int>(n + 1, 0));

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = mat[i-1][j-1]
                          + pre[i-1][j]
                          + pre[i][j-1]
                          - pre[i-1][j-1];
            }
        }

        int low = 1, high = min(m, n), ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            bool found = false;

            for (int i = mid; i <= m && !found; i++) {
                for (int j = mid; j <= n; j++) {
                    int sum = pre[i][j]
                            - pre[i-mid][j]
                            - pre[i][j-mid]
                            + pre[i-mid][j-mid];

                    if (sum <= threshold) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                ans = mid;
                low = mid + 1;   // try bigger square
            } else {
                high = mid - 1;  // reduce size
            }
        }

        return ans;
    }
};
