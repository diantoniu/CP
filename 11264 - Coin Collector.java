import java.util.*;


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      t--;
      int N = sc.nextInt();
      int[] C = new int[N];
      for (int i = 0; i < N; i++) {
        C[i] = sc.nextInt();
      }
      Arrays.sort(C);
      int result = 1, i = 1;
      long sum = C[0];

      while (i < N) {
        while ((i + 1 < N) && ((sum + C[i]) >= C[i + 1])) {
          i++;
        }
        result++;
        sum += C[i];
        i++;
      }
      System.out.println(result);
    }
  }
}
