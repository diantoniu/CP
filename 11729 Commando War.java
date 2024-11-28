import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int T = 0;
        while (true) {
            T++;
            int N = sc.nextInt();
            if (N == 0) {
                break;
            }
            int[][] time = new int[N][2];
            for (int i = 0; i < N; i++) {
                time[i][0] = sc.nextInt();
                time[i][1] = sc.nextInt();
            }
            long result = 0;
            Arrays.sort(time, (t1, t2) -> t2[1] - t1[1]);
            int start = 0;
            for (int i = 0; i < N; i++) {
                start += time[i][0];
                result = Math.max(result, start + time[i][1]);
            }
            bw.write("Case " + T + ": " + result + "\n");
        }
        bw.flush();
    }
}
