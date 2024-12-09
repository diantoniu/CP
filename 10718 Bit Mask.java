import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext())
    {
      long n = sc.nextLong();
      long l = sc.nextLong();
      long u = sc.nextLong();
      long m = 0;
      for (long i = 32; i >= 0; i--) {
        long bit = (1L << i);
        if ((m < l) && ((l & bit) > 0)) {
          m |= bit;
          continue;
        }

        if (((n & bit) == 0) && ((m | bit) <= u)) {
          m |= bit;
        }
      }
      System.out.println(m);
    }
  }
}
