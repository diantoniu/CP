import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
           int n = sc.nextInt();
           if(n == 0) {
               break;
           }
           long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            long max = a[0];
            long localMax = a[0];
            for (int i = 1; i < n; i++) {
                if (localMax < 0) {
                    localMax = a[i];
                } else {
                    localMax += a[i];
                }
                max = Math.max(max, localMax);
            }
            if (max <= 0) {
                System.out.println("Losing streak.");
            } else {
                System.out.printf("The maximum winning streak is %s.%n", max);
            }
        }
    }
}
