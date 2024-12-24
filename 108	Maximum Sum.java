import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int I = sc.nextInt(), J = I;
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
                        - (i - 1 >= 0 && j - 1 >=0 ? a[i - 1][j - 1] : 0);
            }
        }

        long max = Long.MIN_VALUE;
        for (int is = 0; is < I; is++) {
            for (int js = 0; js < J; js++) {

                for (int ie = is; ie < I; ie++) {
                    for (int je = js; je < J; je++) {
                        long sum = a[ie][je]
                                - (is - 1 >= 0 ? a[is - 1][je] : 0)
                                - (js - 1 >= 0 ? a[ie][js - 1] : 0)
                                + (is - 1 >= 0 && js - 1 >= 0 ? a[is - 1][js - 1] : 0);
                        max = Math.max(max, sum);

                    }
                }

            }
        }
        System.out.println(max);
    }
}
