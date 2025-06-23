class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        int a;
        int b;
        for(String c : tokens) {
            switch(c) {
                case "+":
                    numStack.push(numStack.pop() + numStack.pop());
                    break;
                case "-":
                    a = numStack.pop();
                    b = numStack.pop();
                    numStack.push(b - a);
                    break;
                case "*":
                    numStack.push(numStack.pop() * numStack.pop());
                    break;
                case "/":
                    a = numStack.pop();
                    b = numStack.pop();
                    numStack.push(b / a);
                    break;
                default :
                    numStack.push(Integer.valueOf(c));
            }
        }
        return numStack.pop();
    }
}