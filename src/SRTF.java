import java.util.ArrayList;
import java.util.Iterator;

public class SRTF {
    int waitTime = 0;
    ArrayList<Process> arr = new ArrayList<>();
    ProcessGenerator gen = new ProcessGenerator();

    public SRTF(ArrayList<ArrayList<Process>> arrays, int timeBetween){
        int temp_time=0;
        int processingTime = 0;
        int numberOfProcesses=0;
        Iterator<ArrayList<Process>> adArr = arrays.iterator();
        arr.addAll(adArr.next());
        numberOfProcesses=arr.size();
        arr.sort(new SortSJF());
        Iterator<Process> iter = arr.iterator();


        while(iter.hasNext()){
            if (temp_time>=timeBetween){
                temp_time%=timeBetween;
                if (adArr.hasNext()){
                    ArrayList<Process> tt = adArr.next();
                    arr.addAll(tt);
                    numberOfProcesses+=tt.size();
                    arr.sort(new SortSJF());
                    iter = arr.iterator();
                }
            }
            Process p = iter.next();
            if (p.timeToComplete>(timeBetween-temp_time)){
                int delta = timeBetween-temp_time;
                p.timeToComplete-=delta;
                processingTime+=delta;
                temp_time+=delta;
            }else{
                temp_time+=p.timeToComplete;
                processingTime+=p.timeToComplete;
                waitTime += (p.timeWaiting = processingTime-p.timeJoin);
                iter.remove();
            }
        }
        System.out.println("SRTF średni czas: "+waitTime/numberOfProcesses+" dla "+numberOfProcesses+" procesów");
    }
}
