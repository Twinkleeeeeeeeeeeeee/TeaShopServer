package com.hmjy.util;

public class Page {
    private int start; //开始位置数
    private int count; //每页个数
    private int total; //总数
    private String param;

    private static final int defaultCode = 5 ;

    public Page(){
        count = defaultCode;
    }
    public Page(int start,int count){
        this.start = start;
        this.count = count;
    }

    public boolean isHasPreviouse(){
        if(start == 0)
            return false;
        return true;
    }
    public int getLast(){
       int last;
       if(total%count == 0){
           last = total-count;
       }else {
           last = total - total%count;
       }
       last = last < 0?0:last;
       return last;
    }

    public boolean isHasNext(){
        if(start == getLast())
            return false;
        return true;
    }

    public int getTotalPage(){
        int totalpage;
        if(total%count==0){
            totalpage =total/count;
        }else {
            totalpage = (total / count) + 1;
        }
        totalpage = totalpage==0?1:totalpage;
        return totalpage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", count=" + count +
                ", total=" + total +
                ", param='" + param + '\'' +
                '}';
    }
}
