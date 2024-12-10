import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    while(sc.hasNext()) {
      int x1 = sc.nextInt(), y1 = 0, u1 = sc.nextInt(), v1 = sc.nextInt();
      int x2 = 0, y2 = 0, u2 = 0, v2 = 0;
      int c = 0;
      while (x1 != x2 || y1 != y2) {
        x1 += u1;
        y1 += v1;
        if (x2 + (u2 + 1) <= x1) {
          u2++;
        } else {
          u2 = x1 - x2;
        }
        if (y2 + (v2 + 1) <= y1) {
          v2++;
        } else {
          v2 = y1 - y2;
        }
        x2 += u2;
        y2 += v2;
        c++;
      }
      bw.write(c + "\n");
      bw.flush();
    }
  }
}
