import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int caseN = 0;
    while(T > 0) {
      caseN++;
      T--;
      int n = sc.nextInt();
      long d = sc.nextLong();
      long[][] stones = new long[n + 2][2];
      for (int i = 0; i < n; i++) {
        String s = sc.next();
        stones[i][0] = Long.parseLong(s.split("-")[1]);
        stones[i][1] = s.charAt(0) == 'B' ? 2 : 1;
      }
      stones[n][0] = 0;
      stones[n][1] = 2;
      stones[n + 1][0] = d;
      stones[n + 1][1] = 2;
      Arrays.sort(stones, Comparator.comparingLong(o -> o[0]));
      boolean[] used = new boolean[n + 2];
      long res = 0;
      int s = 0;
      while (s < stones.length - 1) {
        int e = s + 1;
        while (stones[e][1] != 2) e++;
        int prev = s;
        for (int j = s + 2; j <= e; j += 2) {
          int nextVal = Math.min(j, e);
          if (stones[nextVal][1] == 1) {
            used[nextVal] = true;
          }
          res = Math.max(stones[nextVal][0]  - stones[prev][0], res);
          prev = nextVal;
        }
        s = e;
      }
      int prev = 0;
      for (int i = 1; i < n + 2; i++) {
        if (!used[i]) {
          res = Math.max(stones[i][0]  - stones[prev][0], res);
          prev = i;
        }
      }
      System.out.println("Case " + caseN + ": " + res);
    }
  }
}
