package appdata;

import java.util.LinkedHashSet;

public class UseCase5TrainConsistMgmnt 
{
    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC5: Preserve Insertion Order of Bogies (LinkedHashSet)");

        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        trainFormation.add("Sleeper");

        System.out.println("Final Train Formation: " + trainFormation);
    }
}
