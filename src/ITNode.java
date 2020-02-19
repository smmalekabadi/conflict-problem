public class ITNode {
    private Interval interval;
    private int max;
    private ITNode left;
    private ITNode right;

    public ITNode(Interval interval) {
        this.interval = interval;
        this.max = interval.getHigh();
    }
    public ITNode insert(ITNode root,Interval i){
        if(root == null)
            return new ITNode(i);
        int l = root.interval.getLow();
        if(i.getLow() < l )
            root.left = insert(root.left,i);
        else
            root.right = insert(root.right,i);
        if(root.max<i.getHigh())
            root.max = i.getHigh();
        return root;
    }
    public static Interval overlapSearch(ITNode root, Interval i){
        if (root == null)
            return null;
        if(i.doOverLap(root.interval))
            return root.interval;

        if (root.left != null && root.left.max >= i.getLow())
            return overlapSearch(root.left,i);
        return overlapSearch(root.right,i);
    }
    public static void printConflicting(Interval [] appt){
        ITNode root = new ITNode(appt[0]);
        for(int i =0 ; i < appt.length ; i++ ){
            Interval res = overlapSearch(root,appt[i]);
            if(res != null)
                System.out.printf("[ %s,%S ] conflicts with [ %s,%S ]\n",
                        appt[i].getLow(),
                        appt[i].getHigh(),
                        res.getLow(),
                        res.getHigh());

         root.insert(root,appt[i]);
        }

    }


    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public ITNode getLeft() {
        return left;
    }

    public void setLeft(ITNode left) {
        this.left = left;
    }

    public ITNode getRight() {
        return right;
    }

    public void setRight(ITNode right) {
        this.right = right;
    }
}
