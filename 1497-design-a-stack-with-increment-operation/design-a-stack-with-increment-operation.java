class CustomStack {

   int[] arrStack;
      int[] incrementArr;
    int size = -1;
    int maxSize = 0;
    public CustomStack(int maxSize) {
       arrStack = new int[maxSize];
        incrementArr = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(size < maxSize - 1) {
            arrStack[++size] = x;
        }
    //    System.out.println(STR."Pushed \{Arrays.toString(arrStack)}");
    }

    public int pop() {
        if(size >= 0) {
            int val = arrStack[size] + incrementArr[size];
            if(size > 0) {
                incrementArr[size - 1] += incrementArr[size];
            }
            incrementArr[size] = 0;
            size--;
            return val;
        } else {
            return -1;
        }
    }

    public void increment(int k, int val) {
//        for(int index = 0; index <= size && index < k && arrStack[index] != -1; index++) {
//            arrStack[index] = arrStack[index] + val;
//        }
    //    System.out.println(STR."Incremented \{Arrays.toString(arrStack)}");
        if (size >= 0) {
            int limit = Math.min(k, size + 1);
            incrementArr[limit - 1] += val; 
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