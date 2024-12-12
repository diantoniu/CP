import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()) {
      long val = sc.nextLong();
      int counter = 0;
      while (val != 0) {
        if (val % 2 == 0) {
          counter++;
          val /= 2;
          continue;
        }
        if (val == 3) {
          counter += 3;
          val = 0;
          continue;
        }
        if (((val - 1) / 2) % 2 == 0) {
          val--;
          counter++;
          continue;
        }
        if (((val + 1) / 2) % 2 == 0) {
          val++;
          counter++;
          continue;
        }
      }
      System.out.println(counter);
    }
  }
}
