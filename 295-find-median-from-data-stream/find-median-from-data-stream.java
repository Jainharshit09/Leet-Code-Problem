class MedianFinder {
    PriorityQueue<Integer>leftMaxHeap;
    PriorityQueue<Integer>rightMinHeap;
    public MedianFinder() {
        leftMaxHeap=new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || leftMaxHeap.peek()>num){
            leftMaxHeap.add(num);
        }
        else{
            rightMinHeap.add(num);
        }

        //make sure the size of leftmax heap will be always equal or large
        if(Math.abs(leftMaxHeap.size()-rightMinHeap.size())>1){
            rightMinHeap.add(leftMaxHeap.poll());
        }
        else if(leftMaxHeap.size()<rightMinHeap.size()){
             leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {

        //even number of elements
        if(leftMaxHeap.size()==rightMinHeap.size()){
            return (double)(leftMaxHeap.peek()+rightMinHeap.peek())/2;
        }

        // odd number of elements
        return leftMaxHeap.peek();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */