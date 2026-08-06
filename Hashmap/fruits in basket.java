import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int maxFruits = 0;
        
        for (int right = 0; right < fruits.length; right++) {
            // Add current fruit to basket map
            int currentFruit = fruits[right];
            basket.put(currentFruit, basket.getOrDefault(currentFruit, 0) + 1);
            
            // If we have more than 2 distinct types, shrink window from left
            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit); // Completely remove type when count reaches 0
                }
                
                left++; // Move start of window rightward
            }
            
            // Update max fruits collected
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
}
