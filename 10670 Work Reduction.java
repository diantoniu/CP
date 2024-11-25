import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int caseNo = 0;
    while (T > 0) {
      T--;
      caseNo++;
      long N = sc.nextLong(), M = sc.nextLong();
      int L = sc.nextInt();
      String[][] result = new String[L][2];
      for (int i = 0; i < L; i++) {
        String agency = sc.next();
        String agencyName = agency.split(":")[0];
        String agencyPrices = agency.split(":")[1];
        long agencyPriceA = Integer.parseInt(agencyPrices.split(",")[0]);
        long agencyPriceB = Integer.parseInt(agencyPrices.split(",")[1]);
        result[i][0] = agencyName;
        long m = N;
        long currentResult = 0;
        while (m != M) {
          long half = m / 2;
          long currentMTarget = Math.max(half, M);
          long aPriceToMTarget = (m - currentMTarget) * agencyPriceA;
          long bPriceToMTarget = (half == currentMTarget) ? agencyPriceB : aPriceToMTarget;
          System.out.println(half + " " + currentMTarget + " " + aPriceToMTarget + " " + bPriceToMTarget) ;
          currentResult += Math.min(aPriceToMTarget, bPriceToMTarget);
          m = currentMTarget;
        }
        result[i][1] = String.valueOf(currentResult);
      }

      Arrays.sort(result, ((o1, o2) -> {
        long p1 = Long.parseLong(o1[1]), p2 = Long.parseLong(o2[1]);
        if (p1 != p2) {
          return Long.compare(p1, p2);
        }
        return o1[0].compareTo(o2[0]);
      }));

      System.out.println("Case " + caseNo + ":");
      for (int i = 0; i < L; i++) {
        String agencyName = result[i][0];
        String price = result[i][1];
        System.out.println(agencyName + " " + price);
      }
    }
  }
}
