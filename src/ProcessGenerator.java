import java.util.ArrayList;
import java.util.Random;

public class ProcessGenerator {
    int number;
    ArrayList<Process> arr;
    Random myRandom;
    public ProcessGenerator(int number){
        this.number=number;
        myRandom=new Random();
        arr=new ArrayList<>();

    }
    public ProcessGenerator(){
        this.number=0;
        arr=new ArrayList<>();
        myRandom=new Random();
    }
    public ArrayList<Process> generate(int number, int time){
        ArrayList<Process> temp = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            temp.add(new Process(temp.size()+i, myRandom.nextInt(49)+1, time+1));
        }
        return temp;
    }
}
