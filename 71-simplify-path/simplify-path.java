class Solution {
    public String simplifyPath(String path) {
        int length = path.length();
        StringBuilder result = new StringBuilder("/");
        Stack<String> resultStack = new Stack<>();

       for(int idx = 1; idx < length; idx++) {
           StringBuilder temp = new StringBuilder();
           while(idx != length && path.charAt(idx) != '/') {
               temp.append(path.charAt(idx));
               idx++;
           }

           if(!temp.toString().equals(".") && !temp.toString().equals("..") && !temp.toString().isEmpty()) {
               resultStack.push(temp.reverse().toString());
           }

           if(!resultStack.empty() && temp.toString().equals("..")) {
               resultStack.pop();
           }
       }

       while(!resultStack.empty()) {
           result.append(resultStack.pop()).append("/");
       }

       if(result.length() == 1) {
         return result.reverse().toString();
       }
       return result.deleteCharAt(0).reverse().toString();
    }
}