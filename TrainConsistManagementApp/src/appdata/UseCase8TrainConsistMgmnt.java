package appdata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import appdata.UseCase7TrainConsistMgmnt;

public class UseCase8TrainConsistMgmnt {
    
    public static void main(String[] args) {
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 36));
        bogieList.add(new Bogie("Second Class", 48));
        bogieList.add(new Bogie("Luxury Sleeper", 84));
        bogieList.add(new Bogie("Economy", 70));

        System.out.println("===== ORIGINAL BOGIE LIST =====");
        bogieList.forEach(System.out::println);

        int threshold = 60;
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(bogie -> bogie.getCapacity() > threshold)
                .collect(Collectors.toList());

        System.out.println("\n===== FILTERED BOGIES (Capacity > " + threshold + ") =====");
        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies found with capacity greater than " + threshold);
        } else {
            filteredBogies.forEach(System.out::println);
        }

        System.out.println("\n===== VERIFICATION: ORIGINAL LIST UNCHANGED =====");
        System.out.println("Original list size: " + bogieList.size());
        System.out.println("Filtered list size: " + filteredBogies.size());
        System.out.println("Are they the same object? " + (bogieList == filteredBogies));
    }
}