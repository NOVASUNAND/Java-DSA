import java.util.Arrays;

class MyHashMap {
    private int[] map;

    public MyHashMap() {
        // Size is 1,000,001 to safely cover keys from 0 up to 1,000,000
        map = new int[1000001];
        // Fill the array with -1 to represent empty slots
        Arrays.fill(map, -1);
    }
    
    public void put(int key, int value) {
        map[key] = value;
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}