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
        int
        ArrayList<Process> arp = new ArrayList<Process>(pg.generate(100, 0, 0));

        FCFS fcfs = new FCFS();
    }
}
