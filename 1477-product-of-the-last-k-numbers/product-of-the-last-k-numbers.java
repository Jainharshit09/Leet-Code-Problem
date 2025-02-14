class ProductOfNumbers {
    ArrayList<Integer>list=new ArrayList<>();
    int size;
    public ProductOfNumbers() {
        this.list.add(1);
        this.size=0;
    }
    
    public void add(int num) {
        if(num==0){
            this.list=new ArrayList<>();
            list.add(1);
            size=0;
        }
        else{
            list.add(list.get(size)*num);
            size++;
        }
    }
    
    public int getProduct(int k) {
        if(size<k){
            return 0;
        }
        return list.get(size)/list.get(size-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */