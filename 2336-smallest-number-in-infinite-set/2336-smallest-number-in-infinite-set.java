class SmallestInfiniteSet {

    private Integer minNum;
    private PriorityQueue<Integer> heap;

    public SmallestInfiniteSet() {
        minNum = 1;
        heap = new PriorityQueue<>();
    }
    
   public int popSmallest() {
        if (!heap.isEmpty()) {
            return heap.poll();
        }
        minNum++;
        return minNum - 1;
    }

    public void addBack(int num) {
        if (minNum > num && !heap.contains(num)) {
            heap.offer(num);
        }
    }
}