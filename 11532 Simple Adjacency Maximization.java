import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = sc.nextInt();
    while(T > 0) {
      T--;
      int P = sc.nextInt(), Q = sc.nextInt();
      long res = 0;
      long len, i;
      if (Q < (P + 1) / 2) {
        len = P + Q;
        i = len - 1;
      } else {
        Q = (P + 1)/ 2;
        len = P + ((P + 1 )/2);
        i = len - 1;
        if (P % 2 == 1) {
          i--;
          res |= (1L << i);
          i--;
          Q--;
          P--;
        }
      }
      while (P > 0 || Q > 0) {
        if (Q > 0) {
          res |= (1L << i);
          res |= (1L << (i - 2));
          i -= 3;
          Q--;
          P -= 2;
          continue;
        }
        res |= (1L << i);
        i--;
        P--;
      }
      System.out.println(res);
    }
  }
}
