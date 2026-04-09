package appdata;

import java.util.ArrayList;

public class UseCase2TrainConsistMgmnt {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC2: Add Passenger Bogies to Train");

        ArrayList<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Passenger Bogies after addition: " + passengerBogies);

        passengerBogies.remove("AC Chair");

        System.out.println("After removing AC Chair: " + passengerBogies);

        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("Does Sleeper exist? " + exists);

        System.out.println("Final Passenger Bogies: " + passengerBogies);
    }
}
