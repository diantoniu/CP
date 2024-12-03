import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      char[] s = sc.next().toCharArray();
      char[] t = sc.next().toCharArray();
      int si = 0, ti = 0;
      while (si < s.length && ti < t.length) {
        while (ti < t.length && s[si] != t[ti]) ti++;
        if (ti < t.length) {
          si++;
          ti++;
        }
      }
      if (si == s.length) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }
  }
}
