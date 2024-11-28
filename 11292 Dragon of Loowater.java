import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        while (true) {
            int D = sc.nextInt(), K = sc.nextInt();
            if (D == 0 && K == 0) {
                break;
            }
            int[] d = new int[D];
            for (int i = 0; i < D; i++) {
                d[i] = sc.nextInt();
            }
            int[] k = new int[K];
            for (int i = 0; i < K; i++) {
                k[i] = sc.nextInt();
            }
            Arrays.sort(d);
            Arrays.sort(k);

            int kI = 0, dI = 0;
            long result = 0;
            while (kI < K && dI < D) {
                while (kI < K && k[kI] < d[dI]) kI++;
                if (kI < K) {
                    result += k[kI];
                    kI++;
                    dI++;
                }
            }
            
            bw.write((dI < D) ? "Loowater is doomed!\n" : (result + "\n"));
        }
        bw.flush();
    }
}
