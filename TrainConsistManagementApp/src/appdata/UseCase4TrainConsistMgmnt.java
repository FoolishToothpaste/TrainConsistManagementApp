package appdata;

import java.util.LinkedList;

public class UseCase4TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC4: Maintain Ordered Train Consist (LinkedList)");

        LinkedList<String> trainConsist = new LinkedList<>();

        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        trainConsist.add(2, "Pantry Car");

        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("Final Train Consist: " + trainConsist);
    }
}
