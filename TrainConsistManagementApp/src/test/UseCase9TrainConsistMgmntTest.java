package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

public class UseCase9TrainConsistMgmntTest {
    
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
    
    // Method to group bogies by type
    private Map<String, List<Bogie>> groupByType(List<Bogie> bogies) {
        if (bogies == null || bogies.isEmpty()) {
            return new HashMap<>();
        }
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }
    
    @Test
    @DisplayName("Test 1: Group bogies correctly by type")
    void testGrouping_BogiesGroupedByType() {
        System.out.println("\n=== TEST 1: Group bogies by type ===");
        
        // Create test data with different types
        List<Bogie> bogies = Arrays.asList(
            new Bogie("Passenger", "Sleeper", 72),
            new Bogie("Passenger", "AC Chair", 56),
            new Bogie("Goods", "Rectangular", 2500),
            new Bogie("Goods", "Cylindrical", 3000)
        );
        
        // Perform grouping
        Map<String, List<Bogie>> result = groupByType(bogies);
        
        // Verify correct grouping
        assertEquals(2, result.size(), "Should have 2 groups (Passenger and Goods)");
        assertTrue(result.containsKey("Passenger"), "Passenger group should exist");
        assertTrue(result.containsKey("Goods"), "Goods group should exist");
        assertEquals(2, result.get("Passenger").size(), "Passenger group should have 2 bogies");
        assertEquals(2, result.get("Goods").size(), "Goods group should have 2 bogies");
        
        System.out.println("✓ Bogies correctly grouped into " + result.size() + " categories");
        System.out.println("  Passenger: " + result.get("Passenger").size() + " bogies");
        System.out.println("  Goods: " + result.get("Goods").size() + " bogies");
    }
    
    @Test
    @DisplayName("Test 2: Multiple bogies in same group")
    void testGrouping_MultipleBogiesInSameGroup() {
        System.out.println("\n=== TEST 2: Multiple bogies in same group ===");
        
        // Create test data with multiple bogies of same type
        List<Bogie> bogies = Arrays.asList(
            new Bogie("Passenger", "Sleeper", 72),
            new Bogie("Passenger", "Sleeper", 72),
            new Bogie("Passenger", "AC Chair", 56),
            new Bogie("Passenger", "First Class", 36)
        );
        
        // Perform grouping
        Map<String, List<Bogie>> result = groupByType(bogies);
        
        // Verify all passenger bogies are in same group
        assertEquals(1, result.size(), "Should have only 1 group (Passenger)");
        assertTrue(result.containsKey("Passenger"), "Passenger group should exist");
        assertEquals(4, result.get("Passenger").size(), "All 4 bogies should be in Passenger group");
        
        System.out.println("✓ All " + result.get("Passenger").size() + " passenger bogies grouped together");
    }
    
    @Test
    @DisplayName("Test 3: Original list unchanged after grouping")
    void testGrouping_OriginalListUnchanged() {
        System.out.println("\n=== TEST 3: Original list unchanged ===");
        
        // Create original list
        List<Bogie> original = new ArrayList<>();
        original.add(new Bogie("Passenger", "Sleeper", 72));
        original.add(new Bogie("Goods", "Rectangular", 2500));
        original.add(new Bogie("Passenger", "AC Chair", 56));
        
        // Create a copy for comparison
        List<Bogie> originalCopy = new ArrayList<>();
        for (Bogie b : original) {
            originalCopy.add(new Bogie(b.getType(), b.getName(), b.getCapacity()));
        }
        
        // Perform grouping operation
        Map<String, List<Bogie>> grouped = groupByType(original);
        
        // Verify original list unchanged
        assertEquals(originalCopy.size(), original.size(), "Original list size should remain same");
        assertEquals(originalCopy.get(0).getType(), original.get(0).getType(), "First bogie type unchanged");
        assertEquals(originalCopy.get(0).getName(), original.get(0).getName(), "First bogie name unchanged");
        assertEquals(originalCopy.get(0).getCapacity(), original.get(0).getCapacity(), "First bogie capacity unchanged");
        
        // Verify grouped map is different from original
        assertNotNull(grouped, "Grouped map should not be null");
        
        System.out.println("✓ Original list unchanged with " + original.size() + " bogies");
        System.out.println("✓ Grouped map created with " + grouped.size() + " categories");
    }
}