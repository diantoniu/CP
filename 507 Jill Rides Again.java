import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int route = 0;
        while (T > 0) {
            route++;
            T--;
            int n = sc.nextInt() - 1;
            int[] r = new int[n];
            for (int i = 0; i < n; i++) {
                r[i] = sc.nextInt();
            }
            int resSum = r[0], resLen = 1, resStart = 0;
            int sum = r[0], len = 1, start = 0;
            for (int i = 1; i < n; i++) {
                if (sum < 0) {
                    sum = r[i];
                    len = 1;
                    start = i;
                } else {
                    sum += r[i];
                    len += 1;
                }
                if ((sum > resSum) || (sum == resSum && len > resLen)) {
                    resSum = sum;
                    resLen = len;
                    resStart = start;
                }
            }

            if (resSum < 1) {
                System.out.printf("Route %s has no nice parts%n", route);
            } else {
                System.out.printf("The nicest part of route %s is between stops %s and %s%n", route, resStart + 1, resStart + 1 + resLen);
            }
        }
    }
}
