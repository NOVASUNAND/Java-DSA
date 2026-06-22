import java.util.*;

public class twosum2point {
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

        // If no breakpoint is found, the array is not rotated
        if (bp == -1) {
            bp = n - 1;
        }

        int lp = (bp + 1) % n; // Left pointer
        int rp = bp; // Right pointer

        // Use two-pointer technique
        while (lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 21; // Changed target to 21 to match list values
        System.out.println(sum(list, target));
    }
}
