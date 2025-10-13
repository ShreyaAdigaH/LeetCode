class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] people = new int[n + 1];
        int[] outgoing = new int[n + 1];
        int[] incoming = new int[n + 1];

        for(int[] arr : trust) {
            outgoing[arr[0]]++;
            incoming[arr[1]]++;
        }

        for(int i = 1; i < n + 1; i++) {
            if(outgoing[i] == 0 && incoming[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}