import java.io.IOException;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while(T > 0) {
      T--;
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      int count = 0;
      for (int i = 1; i < n; i++) {
        if (a[i - 1] > a[i] && (i - 2 >= 0 && a[i - 2] > a[i - 1])) {
          continue;
        }
        if (a[i - 1] < a[i] && (i - 2 >= 0 && a[i - 2] < a[i - 1])) {
          continue;
        }
        count++;
      }
      int sub = 0;
      if (n > 1 && a[0] < a[1]) sub++;
      System.out.println((count - sub) + 1);
    }
  }
}
