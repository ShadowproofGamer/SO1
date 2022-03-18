public class Process {
    int id;
    int timeToComplete;
    int timeJoin;
    int timeWaiting=0;
    boolean completed = false;
    public Process(int id, int timeToComplete, int timeJoin){
        this.id=id;
        this.timeJoin=timeJoin;
        this.timeToComplete=timeToComplete;
    }

}
