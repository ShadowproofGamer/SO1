import java.util.ArrayList;
import java.util.Random;

public class ProcessGenerator {
    private Random myRandom;
    public ProcessGenerator(){
        myRandom=new Random();
    }
    public ArrayList<Process> generate(int number, int time, int start){
        ArrayList<Process> temp = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            temp.add(new Process(i+start, myRandom.nextInt(49)+1, time+1));
        }
        return temp;
    }
}
