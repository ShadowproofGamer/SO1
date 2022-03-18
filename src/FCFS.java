import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;

public class FCFS {
    ArrayList<Process> arr = new ArrayList<>();
    ProcessGenerator gen = new ProcessGenerator();
    public FCFS(){
        long processingTime = 0;
        arr.addAll(gen.generate(1000, 0));
        arr.sort(new SortFCFS<>());
        while(!arr.isEmpty()){
            Iterator<Process> iter = arr.iterator();
            Process p = iter.next();
            processingTime+=p.timeToComplete;
            p.timeToComplete=0;
            p.completed=true;
        }

    }
}
