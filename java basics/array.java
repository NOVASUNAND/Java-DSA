import java.util.*;

public class array {
    public static void main(String[] args) {
        int a[] = {10, 0, 3, 50, 0, 90};
        gret(a);  // Call the method with the array
    }

    public static void gret(int a[]) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < a.length; i++) {
           if(a[i]==0){ 
             for(int j=a.length-1;j>=0;j--){
                a[j]=a[i];
                System.out.println("new array"+a[j]);

           }
          
           }
           else {
            System.out.println("array"+a[i]);
           } 
        }

        
    }
}
