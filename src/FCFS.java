import java.util.ArrayList;
import java.util.Iterator;

public class FCFS {
    int waitTime = 0;
    ArrayList<Process> arr = new ArrayList<>();
    ProcessGenerator gen = new ProcessGenerator();

    public FCFS(ArrayList<ArrayList<Process>> arrays, int timeBetween){
        int temp_time=0;
        int processingTime = 0;
        int numberOfProcesses=0;
        Iterator<ArrayList<Process>> adArr = arrays.iterator();
        arr.addAll(adArr.next());
        numberOfProcesses=arr.size();
        Iterator<Process> iter = arr.iterator();


        while(iter.hasNext()){
            if (temp_time>=timeBetween){
                temp_time%=timeBetween;
                if (adArr.hasNext()){
                    ArrayList<Process> tt = adArr.next();
                    arr.addAll(tt);
                    numberOfProcesses+=tt.size();
                    arr.sort(new SortFCFS<>());
                    iter = arr.iterator();
                }
            }
            Process p = iter.next();
            temp_time+=p.timeToComplete;
            processingTime+=p.timeToComplete;
            waitTime += (p.timeWaiting = processingTime-p.timeJoin);
            iter.remove();
        }
        System.out.println("FCFS średni czas: "+waitTime/numberOfProcesses+" dla "+numberOfProcesses+" procesów");
    }
    public FCFS(){
        doIt();
    }
    public void doIt(){
        int processingTime = 0;
        arr.addAll(gen.generate(100, 0, arr.size()));
        arr.addAll(gen.generate(100, 200, arr.size()));
        arr.addAll(gen.generate(100, 400, arr.size()));
        //arr.sort(new SortFCFS<>());
        Iterator<Process> iter = arr.iterator();
        while(iter.hasNext()){
            Process p = iter.next();
            if (p.timeJoin>processingTime)processingTime=p.timeJoin;
            processingTime+=p.timeToComplete;
            p.timeToComplete=0;
            p.completed=true;
            waitTime += (p.timeWaiting = processingTime-p.timeJoin);
        }System.out.println("FCFS średni czas: "+waitTime/arr.size());

    }
}
