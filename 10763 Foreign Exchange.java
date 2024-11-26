import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      HashMap<Integer, Integer> exchange = new HashMap<>();
      for (int i = 0; i < n; i++) {
        int from = sc.nextInt();
        int to = sc.nextInt();
        exchange.put(from, exchange.getOrDefault(from, 0) + 1);
        exchange.put(to, exchange.getOrDefault(to, 0) - 1);
      }
      String res = "YES";
      for (int v : exchange.values()) {
        if (v != 0) {
          res = "NO";
          break;
        }
      }
      System.out.println(res);
    }
  }
}
