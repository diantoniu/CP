
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;
            int I = Integer.parseInt(br.readLine()), J = I;
            long[][] a = new long[I + I][J + J];
            for (int i = 0; i < I; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < J; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                    a[i + I][j] = a[i][j];
                    a[i][j + J] = a[i][j];
                    a[i + I][j + J] = a[i][j];
                }
            }

            for (int i = 0; i < I + I; i++) {
                for (int j = 0; j < J + J; j++) {
                    a[i][j] = a[i][j]
                            + (i - 1 >= 0 ? a[i - 1][j] : 0)
                            + (j - 1 >= 0 ? a[i][j - 1] : 0)
                            - (i - 1 >= 0 && j - 1 >= 0 ? a[i - 1][j - 1] : 0);
                }
            }

            long max = 0;
            for (int is = 0; is < I + I; is++) {
                for (int js = 0; js < J + J; js++) {

                    for (int ie = is; ie < I + I; ie++) {
                        if (ie - is + 1 > I) {
                            break;
                        }
                        for (int je = js; je < J + J; je++) {
                            if (je - js + 1 > J) {
                                break;
                            }
                            long sum = a[ie][je]
                                    - (is - 1 >= 0 ? a[is - 1][je] : 0)
                                    - (js - 1 >= 0 ? a[ie][js - 1] : 0)
                                    + (is - 1 >= 0 && js - 1 >= 0 ? a[is - 1][js - 1] : 0);
                            max = Math.max(max, sum);

                        }
                    }
                }
            }
            bw.write(max + "\n");
        }
        bw.flush();
    }
}
