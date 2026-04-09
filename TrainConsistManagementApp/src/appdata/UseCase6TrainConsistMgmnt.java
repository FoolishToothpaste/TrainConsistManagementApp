package appdata;

import java.util.HashMap;
import java.util.Map;

public class UseCase6TrainConsistMgmnt {

    public static void main(String[] args) {
        HashMap<String, Integer> bogieCapacityMap = new HashMap<>();

        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 48);
        bogieCapacityMap.put("First Class", 36);
        bogieCapacityMap.put("Rectangular", 2500);   
        bogieCapacityMap.put("Cylindrical", 3000);   

        System.out.println("===== Bogie Capacity Details =====");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            String bogieName = entry.getKey();
            int capacity = entry.getValue();
            System.out.println("Bogie: " + bogieName + " | Capacity: " + capacity);
        }
    }
}
