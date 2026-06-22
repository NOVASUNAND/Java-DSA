import java.util.*;
public class mosttar {
    public static boolean sum(ArrayList<Integer> list, int target) {
        int n = list.size();
        int bp = -1; // breakpoint index

        // Find the breakpoint where the array is rotated
        for (int i = 0; i < n - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                bp = i;
                break;
            }
        }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        int target = 21; 
        System.out.println(sum(list, target));
    }
}
