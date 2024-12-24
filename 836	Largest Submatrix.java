import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T > 0) {
            T--;
            ArrayList<char[]> charArray = new ArrayList<>();
            sc.nextLine();
            charArray.add(sc.nextLine().toCharArray());
            int N = charArray.get(0).length;
            for (int i = 0; i < N - 1; i++) {
                charArray.add(sc.nextLine().toCharArray());
            }

            int I = charArray.size(), J = charArray.get(0).length;
            int[][] a = new int[I][J];
            for (int i = 0; i < I; i++) {
                for (int j = 0; j < J; j++) {
                    a[i][j] = Integer.parseInt(charArray.get(i)[j] + "");
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

            int max = 0;
            for (int is = 0; is < I; is++) {
                for (int js = 0; js < J; js++) {
                    for (int ie = is; ie < I; ie++) {
                        for (int je = js; je < J; je++) {
                            long sum = a[ie][je]
                                    - (is - 1 >= 0 ? a[is - 1][je] : 0)
                                    - (js - 1 >= 0 ? a[ie][js - 1] : 0)
                                    + (is - 1 >= 0 && js - 1 >= 0 ? a[is - 1][js - 1] : 0);
                            int area = (ie - is + 1) * (je - js + 1);
                            if (sum == area) {
                                max = Math.max(area, max);
                            }

                        }
                    }

                }
            }
            System.out.println(max);
            if(T > 0) {
                System.out.println();
            }
        }
    }
}
