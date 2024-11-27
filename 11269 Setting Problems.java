import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int[][] times = new int[n][2];

      for (int i = 0; i < n; i++) {
        times[i][0] = sc.nextInt();
      }
      for (int i = 0; i < n; i++) {
        times[i][1] = sc.nextInt();
      }

      int[][] res = new int[n][2];
      ArrayList<int[]> l1 = new ArrayList<>();
      ArrayList<int[]> l2 = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        if (times[i][0] < times[i][1]) {
          l1.add(times[i]);
        } else {
          l2.add(times[i]);
        }
      }

      l1.sort((t1, t2) -> {
        return t1[0] - t2[0]; // for any [0, e1] [0, e2] second would wait the least amount of time if we put the shortest t1[0]
      });

      l2.sort((t1, t2) -> {
        return t2[1] - t1[1];
      });

      int ind = 0;
      for (int i = 0; i < l1.size(); i++) {
        res[ind] = l1.get(i);
        ind++;
      }

      for (int i = 0; i < l2.size(); i++) {
        res[ind] = l2.get(i);
        ind++;
      }

      int prev1End = 0, current1End = 0;
      int prev2End = 0, current2End = 0;

      for (int i = 0; i < n; i++) {
        current1End = prev1End + res[i][0];
        current2End = Math.max(prev2End, current1End) + res[i][1];

        prev1End = current1End;
        prev2End = current2End;
      }
      System.out.println(current2End);
    }
  }
}
