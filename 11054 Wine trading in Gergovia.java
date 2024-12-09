import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      long[] a = new long[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextLong();
      }
      ArrayDeque<long[]> q = new ArrayDeque<>();
      int i = 0;
      long res = 0;
      while (i < n) {
        if (q.isEmpty() || (q.getFirst()[1] < 0 && a[i] < 0) || (q.getFirst()[1] > 0 && a[i] > 0)) {
          q.addFirst(new long[] {i, a[i]});
          i++;
          continue;
        }
        while (a[i] > 0 && !q.isEmpty() && q.getFirst()[1] < 0) {
          long[] val = q.pollFirst();
          long diff = Math.min(Math.abs(a[i]), Math.abs(val[1]));
          a[i] -= diff;
          val[1] += diff;
          res += (i - val[0]) * diff;
          if(val[1] != 0) {
            q.addFirst(val);
          }
        }
        while (a[i] < 0 && !q.isEmpty() && q.getFirst()[1] > 0) {
          long[] val = q.pollFirst();
          long diff = Math.min(Math.abs(a[i]), Math.abs(val[1]));
          a[i] += diff;
          val[1] -= diff;
          res += (i - val[0]) * diff;
          if(val[1] != 0) {
            q.addFirst(val);
          }
        }
        if (a[i] != 0) {
          q.addFirst(new long[] {i, a[i]});
        }
        i++;
      }
      System.out.println(res);
    }
  }
}
