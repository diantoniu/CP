import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int caseNo = 0;
    while (T > 0) {
      T--;
      caseNo++;
      int N = sc.nextInt(), M = sc.nextInt(), L = sc.nextInt();
      String[][] result = new String[L][2];
      for (int i = 0; i < L; i++) {
        String agency = sc.next();
        String agencyName = agency.split(":")[0];
        String agencyPrices = agency.split(":")[1];
        int a = Integer.parseInt(agencyPrices.split(",")[0]);
        int b = Integer.parseInt(agencyPrices.split(",")[1]);
        result[i][0] = agencyName;
        int res = 0;
        int n = N;
        while (n != M) {
          int half = n / 2;
          int currentMTarget = Math.max(half, M);
          int aPriceToMTarget = (n - currentMTarget) * a;
          int bPriceToMTarget = (half == currentMTarget) ? b : aPriceToMTarget;
          res += Math.min(aPriceToMTarget, bPriceToMTarget);
          n = currentMTarget;
        }
        result[i][1] = String.valueOf(res);
      }

      Arrays.sort(result, ((o1, o2) -> {
        int p1 = Integer.parseInt(o1[1]), p2 = Integer.parseInt(o2[1]);
        if (p1 != p2) {
          return p1 - p2;
        }
        return o1[0].compareTo(o2[0]);
      }));

      System.out.println("Case " + caseNo);
      for (int i = 0; i < L; i++) {
        String agencyName = result[i][0];
        String price = result[i][1];
        System.out.println(agencyName + " " + price);
      }
    }
  }
}
