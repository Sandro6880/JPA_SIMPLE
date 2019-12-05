package demo;

public class AwesomePeopleCount {
    private boolean isAwesome;
    private long count;

    public AwesomePeopleCount(boolean isAwesome, long count){
        this.isAwesome = isAwesome;
        this.count = count;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public long getCount() {
        return count;
    }
}
