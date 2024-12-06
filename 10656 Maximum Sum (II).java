import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      if (n == 0) {
        break;
      }
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < n; i++) {
        int a = sc.nextInt();
        if (a > 0) {
          stringBuilder.append(a).append(" ");
        }
      }
      if (stringBuilder.length() == 0) {
        stringBuilder.append("0");
      }
      System.out.println(stringBuilder.toString().trim());
    }
  }
}
