import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int I = sc.nextInt(), J = sc.nextInt(), K = sc.nextInt();
            long[][][] a = new long[I][J][K];
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    for (int k = 0; k < K; k++) {
                        a[i][j][k] = sc.nextLong();
                    }
                }
            }
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    for (int k = 0; k < K; k++) {
                        a[i][j][k] = a[i][j][k]
                                + (i - 1 >= 0 ? a[i - 1][j][k] : 0)
                                + (j - 1 >= 0 ? a[i][j - 1][k] : 0)
                                + (k - 1 >= 0 ? a[i][j][k - 1] : 0)
                                - (i - 1 >= 0 && j - 1 >=0 ? a[i - 1][j - 1][k] : 0)
                                - (i - 1 >= 0 && k - 1 >=0 ? a[i - 1][j][k - 1] : 0)
                                - (j - 1 >= 0 && k - 1 >=0 ? a[i][j - 1][k - 1] : 0)
                                + (i - 1 >= 0 && j - 1 >= 0 && k - 1 >=0 ? a[i - 1][j - 1][k - 1] : 0);
                    }
                }
            }

            long max = Long.MIN_VALUE;

            for (int is = 0; is < I; is++) {
                for (int js = 0; js < J; js++) {
                    for (int ks = 0; ks < K; ks++) {
                        for (int ie = is; ie < I; ie++) {
                            for (int je = js; je < J; je++) {
                                for (int ke = ks; ke < K; ke++) {
                                    long sum = a[ie][je][ke]
                                            - (is - 1 >= 0 ? a[is - 1][je][ke] : 0)
                                            - (js - 1 >= 0 ? a[ie][js - 1][ke] : 0)
                                            - (ks - 1 >= 0 ? a[ie][je][ks - 1] : 0)
                                            + (is - 1 >= 0 && js - 1 >= 0 ? a[is - 1][js - 1][ke] : 0)
                                            + (is - 1 >= 0 && ks - 1 >= 0 ? a[is - 1][je][ks - 1] : 0)
                                            + (js - 1 >= 0 && ks - 1 >= 0 ? a[ie][js - 1][ks - 1] : 0)
                                            - (is - 1 >= 0 && js - 1 >= 0 && ks - 1 >= 0 ? a[is - 1][js - 1][ks - 1] : 0);
                                    max = Math.max(max, sum);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(max);
            if (t > 0) {
                System.out.println();
            }
        }
    }
}
