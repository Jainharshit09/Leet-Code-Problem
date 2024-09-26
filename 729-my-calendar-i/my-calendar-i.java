class MyCalendar {
    List<int[]>calander;
    public MyCalendar() {
        calander=new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int []curr:calander){
             if(!(end <= curr[0] || start >= curr[1])){
                return false;
             }
        }
         calander.add(new int[]{start, end});
         return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */