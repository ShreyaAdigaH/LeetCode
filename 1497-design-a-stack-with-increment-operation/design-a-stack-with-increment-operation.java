class CustomStack {

   int[] arrStack;
    int size = -1;
    int maxSize = 0;
    public CustomStack(int maxSize) {
        arrStack = new int[maxSize];
        this.maxSize = maxSize;
        Arrays.fill(arrStack, -1);
    }

    public void push(int x) {
        if(size < maxSize - 1) {
            arrStack[++size] = x;
        }
    
    }

    public int pop() {
        if(size >= 0) {
            int val = arrStack[size];
            arrStack[size--] = -1;
            return val;
        } else {
            return -1;
        }
    }

    public void increment(int k, int val) {
        for(int index = 0; index <= size && index < k && arrStack[index] != -1; index++) {
            arrStack[index] = arrStack[index] + val;
        }


    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */