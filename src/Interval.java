public class Interval {
    private int low;
    private int high;

    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }
    public boolean doOverLap(Interval i1){
        if(i1.getLow() < this.getHigh() && this.low < i1.getHigh())
            return true;
        return false;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }
}
