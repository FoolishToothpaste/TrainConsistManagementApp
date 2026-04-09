package test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Test class for UC8: Filter Passenger Bogies Using Streams
 * Contains 3 key test cases for filtering bogies by capacity
 */
public class UseCase8TrainConsistMgmntTest {
    
    // Bogie class for testing
    static class Bogie {
        private String name;
        private int capacity;
        
        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
        
        public String getName() { return name; }
        public int getCapacity() { return capacity; }
        
        @Override
        public String toString() {
            return name + "(" + capacity + ")";
        }
    }
    
    // Filter method using Stream API
    private List<Bogie> filterByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }
    
    @Test
    @DisplayName("Test 1: Filter bogies with capacity greater than threshold")
    void testFilter_CapacityGreaterThanThreshold() {
        System.out.println("\n=== Test 1: Capacity > 70 ===");
        
        // Create test data
        List<Bogie> bogies = Arrays.asList(
            new Bogie("Sleeper", 72),
            new Bogie("AC Chair", 56),
            new Bogie("Luxury Sleeper", 84),
            new Bogie("Economy", 70)
        );
        
        // Filter bogies with capacity > 70
        List<Bogie> result = filterByCapacity(bogies, 70);
        
        // Verify results
        assertEquals(2, result.size(), "Should have 2 bogies with capacity > 70");
        assertEquals("Sleeper", result.get(0).getName());
        assertEquals("Luxury Sleeper", result.get(1).getName());
        
        System.out.println("✓ Bogies with capacity > 70: " + result);
    }
    
    @Test
    @DisplayName("Test 2: Filter when no bogies match the condition")
    void testFilter_NoBogiesMatching() {
        System.out.println("\n=== Test 2: No bogies match (all capacities < threshold) ===");
        
        // Create test data with all capacities below threshold
        List<Bogie> bogies = Arrays.asList(
            new Bogie("First Class", 36),
            new Bogie("Second Class", 48),
            new Bogie("AC Chair", 56)
        );
        
        // Filter with high threshold
        List<Bogie> result = filterByCapacity(bogies, 70);
        
        // Verify empty result
        assertTrue(result.isEmpty(), "Filtered list should be empty when no bogies match");
        assertEquals(0, result.size());
        
        System.out.println("✓ Empty list returned as expected");
    }
    
    @Test
    @DisplayName("Test 3: Original list remains unchanged after filtering")
    void testFilter_OriginalListUnchanged() {
        System.out.println("\n=== Test 3: Original list integrity ===");
        
        // Create original list
        List<Bogie> original = new ArrayList<>();
        original.add(new Bogie("Sleeper", 72));
        original.add(new Bogie("Economy", 70));
        original.add(new Bogie("First Class", 36));
        
        // Create a copy for comparison
        List<Bogie> originalCopy = new ArrayList<>();
        for (Bogie b : original) {
            originalCopy.add(new Bogie(b.getName(), b.getCapacity()));
        }
        
        // Perform filter operation
        List<Bogie> filtered = filterByCapacity(original, 60);
        
        // Verify original list unchanged
        assertEquals(originalCopy.size(), original.size(), "Original list size should remain same");
        assertEquals(originalCopy.get(0).getName(), original.get(0).getName(), "First bogie unchanged");
        assertEquals(originalCopy.get(0).getCapacity(), original.get(0).getCapacity(), "Capacity unchanged");
        
        // Verify filtered list is different object
        assertNotSame(original, filtered, "Filtered list should be a new list");
        
        System.out.println("✓ Original list unchanged: " + original.size() + " bogies preserved");
        System.out.println("✓ Filtered list created as new list with " + filtered.size() + " bogies");
    }
}