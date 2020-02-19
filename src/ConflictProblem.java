public class ConflictProblem {
    public static void main(String []args){
        Interval [] appts =  new Interval[6];
        appts[0] = new Interval(1,5);
        appts[1] = new Interval(3,7);
        appts[2] = new Interval(2,6);
        appts[3] = new Interval(10,15);
        appts[4] = new Interval(5,6);
        appts[5] = new Interval(4,100);

        ITNode.printConflicting(appts);
    }
}
