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
            int I = sc.nextInt(), J = sc.nextInt();
            long[][] a = new long[I][J];
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    a[i][j] = sc.nextLong();
                }
            }
            if(I == 0 && J == 0) {
                break;
            }

            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    a[i][j] = a[i][j]
                            + (i - 1 >= 0 ? a[i - 1][j] : 0)
                            + (j - 1 >= 0 ? a[i][j - 1] : 0)
                            - (i - 1 >= 0 && j - 1 >= 0 ? a[i - 1][j - 1] : 0);
                }
            }
            int max = 0;
            for (int is = 0; is < I; is++) {
                for (int js = 0; js < J; js++) {

                    for (int ie = is; ie < I; ie++) {
                        for (int je = js; je < J; je++) {
                            long sum = a[ie][je]
                                    - (is - 1 >= 0 ? a[is - 1][je] : 0)
                                    - (js - 1 >= 0 ? a[ie][js - 1] : 0)
                                    + (is - 1 >= 0 && js - 1 >= 0 ? a[is - 1][js - 1] : 0);
                            if (sum == 0) {
                                int totalArea = (ie - is + 1) * (je - js + 1);
                                max = Math.max(max, totalArea);
                            }

                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}
