class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n1 = v1.length, n2 = v2.length;
        int i = 0, j = 0;

        while (i < n1 || j < n2) {
            int num1 = (i < n1) ? Integer.parseInt(v1[i++]) : 0;
            int num2 = (j < n2) ? Integer.parseInt(v2[j++]) : 0;

            if (num1 != num2)
                return Integer.compare(num1, num2);
        }

        return 0;
    }
}