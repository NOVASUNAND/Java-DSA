import java.util.*;

public class Solution {
    public static void swap( ArrayList<Integer> list,int indx1,int indx2){
        int temp=list.get(indx1);
        list.set(indx1, list.get(indx2));
        list.set(indx2,temp);
    }
    public static void main(String[] args) {
        // Create an ArrayList of integers
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int indx1=1,indx2=3;
        System.out.println(list);
        System.out.println("Size of list: " + list.size());
        System.out.print("Elements in reverse order: ");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println(); 
        swap(list, indx1, indx2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);


    }
}
