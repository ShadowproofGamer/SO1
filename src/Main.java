import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProcessGenerator pg = new ProcessGenerator();
        ArrayList<ArrayList<Process>> arrays = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Wpisz liczbę procesów na transze: ");
        int amountP = scan.nextInt();
        System.out.println("Wpisz liczbę transz: ");
        int amountA = scan.nextInt();
        System.out.println("Wpisz odstęp (w milisekundach) pomiędzy transzami: ");
        int timeBetween = scan.nextInt();
        System.out.println("Wpisz kwant czasu (w milisekundach): ");
        int timeQuant = scan.nextInt();
        for (int i = 0; i < amountA; i++) {
            arrays.add(new ArrayList<Process>(pg.generate(amountP, timeBetween*i, amountP*i+1)));
        }


        FCFS fcfs = new FCFS(arrays, timeBetween);
        SJF sjf = new SJF(arrays, timeBetween);
        SRTF srtf = new SRTF(arrays, timeBetween);
        RR rr = new RR(arrays, timeBetween, timeQuant);
    }
}
