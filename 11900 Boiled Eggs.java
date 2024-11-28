import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int t = 0, T = sc.nextInt();
        while (t < T) {
            t++;
            int N = sc.nextInt(), P = sc.nextInt(), Q = sc.nextInt();
            int[] W = new int[N];
            for (int i = 0; i < N; i++) {
                W[i] = sc.nextInt();
            }
            Arrays.sort(W);
            int resultCount = 0, resultGM = 0;
            for (int i = 0; i < N; i++) {
                if (resultCount < P && (resultGM + W[i]) <= Q) {
                    resultCount++;
                    resultGM += W[i];
                } else {
                    break;
                }
            }
            bw.write("Case " + t + ": " + resultCount + "\n");
        }
        bw.flush();
    }
}
