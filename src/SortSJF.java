import java.util.Comparator;

public class SortSJF implements Comparator<Process> {


    @Override
    public int compare(Process o, Process o1) {
        return Integer.compare(o.timeToComplete, o1.timeToComplete);
    }
}
