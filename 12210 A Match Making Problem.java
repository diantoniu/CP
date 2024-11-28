import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int t = 0;
        while (true) {
            t++;
            int B = sc.nextInt(), S = sc.nextInt();
            if (B == 0 && S == 0) {
                break;
            }
            int minB = Integer.MAX_VALUE;
            int[] b = new int[B];
            for (int i = 0; i < B; i++) {
                b[i] = sc.nextInt();
                minB = Math.min(minB, b[i]);
            }
            int[] s = new int[S];
            for (int i = 0; i < S; i++) {
                s[i] = sc.nextInt();
            }
            if (B <= S) {
                bw.write("Case " + t + ": " + 0 + "\n");
            } else {
                bw.write("Case " + t + ": " + (B - S) + " " + minB + "\n");
            }
        }
        bw.flush();
    }
}
