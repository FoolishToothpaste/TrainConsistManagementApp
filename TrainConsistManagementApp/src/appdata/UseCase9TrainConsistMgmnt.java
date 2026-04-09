package appdata;

import java.util.*;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmnt {
    
    // Bogie class with type and capacity
    static class Bogie {
        private String type;
        private String name;
        private int capacity;
        
        public Bogie(String type, String name, int capacity) {
            this.type = type;
            this.name = name;
            this.capacity = capacity;
        }
        
        public String getType() { return type; }
        public String getName() { return name; }
        public int getCapacity() { return capacity; }
        
        @Override
        public String toString() {
            return name + "(" + capacity + ")";
        }
    }
    
    public static void main(String[] args) {
        // Create list of bogies
        List<Bogie> bogies = Arrays.asList(
            new Bogie("Passenger", "Sleeper", 72),
            new Bogie("Passenger", "AC Chair", 56),
            new Bogie("Passenger", "First Class", 36),
            new Bogie("Goods", "Rectangular", 2500),
            new Bogie("Goods", "Cylindrical", 3000),
            new Bogie("Passenger", "Sleeper", 72),
            new Bogie("Passenger", "AC Chair", 56)
        );
        
        System.out.println("===== ORIGINAL BOGIE LIST =====");
        bogies.forEach(b -> System.out.println(b.getType() + ": " + b));
        
        // Group bogies by type using Collectors.groupingBy()
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
        
        System.out.println("\n===== BOGIES GROUPED BY TYPE =====");
        groupedBogies.forEach((type, bogieList) -> {
            System.out.println("\n" + type + " Bogies (" + bogieList.size() + "):");
            bogieList.forEach(b -> System.out.println("  - " + b));
        });
        
        // Alternative: Group by bogie name (type as in passenger class)
        System.out.println("\n===== BOGIES GROUPED BY NAME =====");
        Map<String, List<Bogie>> groupedByName = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
        
        groupedByName.forEach((name, bogieList) -> {
            System.out.println(name + ": " + bogieList.size() + " bogie(s)");
        });
    }
}