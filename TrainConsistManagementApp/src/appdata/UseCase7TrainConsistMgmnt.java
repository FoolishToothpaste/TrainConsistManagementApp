package appdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie: " + name + " | Capacity: " + capacity;
    }
}

public class UseCase7TrainConsistMgmnt {
    public static void main(String[] args) {
        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 36));
        bogieList.add(new Bogie("Second Class", 48));
        bogieList.add(new Bogie("Luxury Sleeper", 84));

        System.out.println("===== Original Bogie Order =====");
        for (Bogie bogie : bogieList) {
            System.out.println(bogie);
        }

        Collections.sort(bogieList, Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\n===== Bogies Sorted by Capacity (Ascending) =====");
        for (Bogie bogie : bogieList) {
            System.out.println(bogie);
        }

        Collections.sort(bogieList, Comparator.comparingInt(Bogie::getCapacity).reversed());

        System.out.println("\n===== Bogies Sorted by Capacity (Descending) =====");
        for (Bogie bogie : bogieList) {
            System.out.println(bogie);
        }
    }
}
