import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean initial = true;
        while (sc.hasNext()) {
            int I = sc.nextInt(), J = I;
            int M = sc.nextInt();
            long[][] a = new long[I][J];
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    a[i][j] = sc.nextLong();
                }
            }

            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    a[i][j] = a[i][j]
                            + (i - 1 >= 0 ? a[i - 1][j] : 0)
                            + (j - 1 >= 0 ? a[i][j - 1] : 0)
                            - (i - 1 >= 0 && j - 1 >= 0 ? a[i - 1][j - 1] : 0);
                }
            }
            ArrayList<Long> res = new ArrayList<>();
            long total = 0;

            for (int is = 0; is < I; is++) {
                for (int js = 0; js < J; js++) {
                    int ie = is + M - 1;
                    int je = js + M - 1;
                    if (ie >= I || je >= J) {
                        continue;
                    }
                    long sum = a[ie][je]
                            - (is - 1 >= 0 ? a[is - 1][je] : 0)
                            - (js - 1 >= 0 ? a[ie][js - 1] : 0)
                            + (is - 1 >= 0 && js - 1 >= 0 ? a[is - 1][js - 1] : 0);
                    res.add(sum);
                    total += sum;
                }
            }
            res.add(total);
            if (!initial) {
                bw.write("\n");
            }
            initial = false;
            for (int i = 0; i < res.size(); i++) {
                bw.write(res.get(i) + "\n");
            }
            bw.flush();
        }
    }
}
