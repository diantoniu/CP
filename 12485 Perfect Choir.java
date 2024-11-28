import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
           int N = sc.nextInt();
            long[] a = new long[N];
           long sum = 0;
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
            }
            if (sum % N != 0) {
                bw.write("-1\n");
                continue;
            }
            sum /= N;
            Arrays.sort(a);
            int l = 0, r = N - 1;
            long count = 0;
            while (l < r) {
                while (l < N && a[l] == sum) l++;
                while (r >= 0 && a[r] == sum) r--;
                if (l < r) {
                    long under = sum - a[l];
                    long over = a[r] - sum;
                    long take = Math.min(under, over);
                    a[l] += take;
                    a[r] -= take;
                    count += take;
                }
            }
            count += 1;
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
