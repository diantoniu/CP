import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            long[] a = new long[7];
            long sum = 0;
            for (int i = 1; i <= 6; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
            }
            if (sum == 0) {
                break;
            }

            // 6 5 4 3
            long result = a[6] + a[5] + a[4] + (a[3] / 4) + (a[3] % 4 == 0 ? 0 : 1);
            
            long av2 = 0, av1 = 0;
            // 1 from 5
            av1 += a[5] * 11;
            // 2 from 4
            av2 += a[4] * 5;
            // 1 and 2 from 3
            if (a[3] % 4 == 1) {
                av1 += 7;
                av2 += 5;
            } else if (a[3] % 4 == 2) {
                av1 += 6;
                av2 += 3;
            } else if (a[3] % 4 == 3) {
                av1 += 5;
                av2 += 1;
            }

            // 2
            if (a[2] > av2) {
                a[2] -= av2;
                result += a[2] / 9 + (a[2] % 9 == 0 ? 0 : 1);
                av1 += (a[2] % 9 == 0 ? 0 : (2*2*(9 - a[2] % 9)));
            } else  {
                av2 -= a[2];
                av1 += 2*2*av2;
            }

            // 1
            if (a[1] > av1) {
                a[1] -= av1;
                result += a[1] / 36 + (a[1] % 36 == 0 ? 0 : 1);
            }
            System.out.println(result);
        }

    }
}
