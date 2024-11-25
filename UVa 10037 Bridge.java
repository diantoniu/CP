import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T > 0){
      T--;
      int n = sc.nextInt();
      long[] t = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        t[i] = sc.nextInt();
      }
        int totalTime = 0;
        Arrays.sort(t);
        int c = n;
        String res = "";
        while (c >= 4) {
          // why WA when t1 = t[2] + t[2]; t2 = t[c - 1] + t[1];
          long t1 = t[1] + t[c] + t[2] + t[2];
          long t2 = t[1] + t[c] + t[c - 1] + t[1];
          if (t1 < t2) {
            totalTime += t1;
            res += t[1] + " " + t[2] + "\n";
            res += t[1] + "\n";
            res += t[c - 1] + " " + t[c] + "\n";
            res += t[2] + "\n";
          } else {
            totalTime += t2;
            res += t[1] + " " + t[c] + "\n";
            res += t[1] + "\n";
            res += t[1] + " " + t[c - 1] + "\n";
            res += t[1] + "\n";
          }
          c -= 2;
        }

      if (c == 3) {
        totalTime += t[2] + t[1] + t[3];
        res += t[1] + " " + t[2] + "\n";
        res += t[1] + "\n";
        res += t[1] + " " + t[3] + "\n";
      } else if (c == 2) {
        totalTime += t[2];
        res += t[1] + " " + t[2] + "\n";
      } else {
        totalTime += t[1];
        res += t[1] + "\n";
      }

      System.out.println(totalTime);
      System.out.print(res);
      if (T > 0) {
        System.out.println();
      }
    }
  }
}

