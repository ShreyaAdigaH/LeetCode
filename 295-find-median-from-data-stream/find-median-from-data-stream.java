import java.util.*;
import java.util.function.BiFunction;

class MedianFinder {
    private double median;
    private Heap maxHeap;
    private Heap minHeap;

    public MedianFinder() {
        maxHeap = new Heap((a, b) -> a > b); // Max-heap for lower half
        minHeap = new Heap((a, b) -> a < b); // Min-heap for upper half
        median = 0;
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.insert(num);
        } else {
            minHeap.insert(num);
        }
        balanceHeap();
        computeMedian();
    }

    private void balanceHeap() {
        if (minHeap.size() - maxHeap.size() == 2) {
            maxHeap.insert(minHeap.remove());
        } else if (maxHeap.size() - minHeap.size() == 2) {
            minHeap.insert(maxHeap.remove());
        }
    }

    private void computeMedian() {
        if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();
        } else if (maxHeap.size() > minHeap.size()) {
            median = maxHeap.peek();
        } else {
            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }

    public double findMedian() {
        return median;
    }

    static class Heap {
        private final List<Integer> heap;
        private final BiFunction<Integer, Integer, Boolean> func;

        public Heap(BiFunction<Integer, Integer, Boolean> func) {
            this.heap = new ArrayList<>();
            this.func = func;
        }

        public void insert(int val) {
            heap.add(val);
            siftUp(heap.size() - 1);
        }

        public int remove() {
            if (heap.isEmpty()) return -1;
            int val = heap.get(0);
            swap(0, heap.size() - 1);
            heap.remove(heap.size() - 1);
            siftDown(0);
            return val;
        }

        public int peek() {
            return heap.get(0);
        }

        public int size() {
            return heap.size();
        }

        private void siftUp(int idx) {
            int parentIdx = (idx - 1) / 2;
            while (idx > 0 && func.apply(heap.get(idx), heap.get(parentIdx))) {
                swap(idx, parentIdx);
                idx = parentIdx;
                parentIdx = (idx - 1) / 2;
            }
        }

        private void siftDown(int idx) {
            int left = 2 * idx + 1;
            while (left < heap.size()) {
                int right = left + 1;
                int swapIdx = left;

                if (right < heap.size() && func.apply(heap.get(right), heap.get(left))) {
                    swapIdx = right;
                }

                if (func.apply(heap.get(swapIdx), heap.get(idx))) {
                    swap(idx, swapIdx);
                    idx = swapIdx;
                    left = 2 * idx + 1;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }
}
