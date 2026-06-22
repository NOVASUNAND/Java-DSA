import java.util.*;

public class sol {
    public ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        // Sort the input list
        Collections.sort(nums);

        ArrayList<Integer> list = new ArrayList<>();
        
        // Iterate through the list, skipping the first and last elements
        for (int i = 1; i < nums.size() - 1; i++) {
            // Check if nums[i] is a "lonely" number
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i));
            }
        }
        
        // Handle the case where the list has only one element
        if (nums.size() == 1) {
            list.add(nums.get(0));
        }
        
        // Check if the first and last elements are "lonely"
        if (nums.size() > 1) {
            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }
            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        // Example usage
        sol solution = new sol();
        
        // Create an ArrayList of integers
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 6, 5, 8));

        // Find and print lonely numbers
        ArrayList<Integer> lonelyNumbers = solution.findLonely(nums);
        System.out.println("Lonely Numbers: " + lonelyNumbers);
    }
}
