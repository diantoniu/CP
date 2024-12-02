import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T > 0) {
      T--;
      int n = sc.nextInt();
      ArrayList<Integer> res = new ArrayList<>();
      int start = 2, sum = 0;
      while (sum + start <= n) {
        res.add(start);
        sum += start;
        start++;
      }
      int rest = n - sum;
      int addToAll = (rest / res.size());
      int addToSome = rest % res.size();
      for (int i = res.size() - 1; i >= 0; i--) {
        res.set(i, res.get(i) + addToAll + Math.min(addToSome, 1));
        addToSome = Math.max(addToSome - 1, 0);
      }
      for (int i = 0; i < res.size(); i++) {
        System.out.print(res.get(i) + (i == (res.size() - 1) ? "\n" : " "));
      }
      if (T > 0) {
        System.out.println();
      }
    }
  }
}
