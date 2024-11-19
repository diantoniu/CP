import java.util.*;


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int N = sc.nextInt(), D = sc.nextInt(), R = sc.nextInt();
      if (N == 0 && D == 0 && R == 0) {
        return;
      }
      ArrayList<Integer> morning = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        morning.add(sc.nextInt());
      }
      ArrayList<Integer> evening = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        evening.add(sc.nextInt());
      }
      Collections.sort(morning);
      evening.sort(Collections.reverseOrder());
      long result = 0;

      for (int i = 0; i < N; i++) {
        long additionalDist = Math.max(0, (morning.get(i) + evening.get(i)) - D);
        result += (additionalDist * R);
      }

      System.out.println(result);
    }
  }
}
