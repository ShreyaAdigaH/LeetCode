class Solution {
    public String simplifyPath(String path) {
        char[] pathArray = path.toCharArray();
        StringBuilder result = new StringBuilder("/");
        Stack<String> resultStack = new Stack<>();

        for (int idx = 1; idx < pathArray.length; idx++) {
            StringBuilder temp = new StringBuilder();
            while (idx != pathArray.length && pathArray[idx] != '/') {
                temp.append(pathArray[idx]);
                idx++;
            }

            if (!temp.toString().equals(".") && !temp.toString().equals("..") && !temp.toString().isEmpty()) {
                resultStack.push(temp.reverse().toString());
            }

            if (!resultStack.empty() && temp.toString().equals("..")) {
                resultStack.pop();
            }
        }

        while (!resultStack.empty()) {
            result.append(resultStack.pop()).append("/");
        }

        if (result.length() == 1) {
            return result.reverse().toString();
        }
        return result.deleteCharAt(0).reverse().toString();
    }
}