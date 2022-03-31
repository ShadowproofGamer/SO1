import java.util.ArrayList;
import java.util.Iterator;

public class RR {
    int waitTime = 0;
    ArrayList<Process> arr = new ArrayList<>();
    ProcessGenerator gen = new ProcessGenerator();

    public RR(ArrayList<ArrayList<Process>> arrays, int timeBetween, int timeQuant){
        int temp_time=0;
        int processingTime = 0;
        int numberOfProcesses=0;
        Iterator<ArrayList<Process>> adArr = arrays.iterator();
        arr.addAll(adArr.next());
        numberOfProcesses=arr.size();
        Iterator<Process> iter = arr.iterator();


        while(arr.size()!=0){
            if (!iter.hasNext())iter= arr.iterator();
            if (temp_time>=timeBetween){
                temp_time%=timeBetween;
                if (adArr.hasNext()){
                    ArrayList<Process> tt = adArr.next();
                    arr.addAll(tt);
                    numberOfProcesses+=tt.size();
                    iter = arr.iterator();
                }
            }
            Process p = iter.next();
            temp_time+=timeQuant;
            p.timeToComplete-=timeQuant;
            processingTime+=timeQuant;
            if (p.timeToComplete<=0){
                waitTime += (p.timeWaiting = processingTime-p.timeJoin);
                iter.remove();
            }

        }
        System.out.println("RoundRobin średni czas: "+waitTime/numberOfProcesses+" dla "+numberOfProcesses+" procesów");
    }
}
