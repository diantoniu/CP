import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int L = Integer.parseInt(st.nextToken()), G = Integer.parseInt(st.nextToken());
      if (L == 0 && G == 0) {
        return;
      }
      ArrayList<int[]> segments = new ArrayList<>();
      for (int i = 0; i < G; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());
        segments.add(new int[] {x - r, x + r});
      }
      segments.sort(Comparator.comparingInt(o -> o[0]));
      int r = 0, count = 0, i = 0;
      while (i < G) {
        if (segments.get(i)[0] > r) {
          break;
        }

        int nextR = r;
        while (i < G && segments.get(i)[0] <= r) {
          nextR = Math.max(nextR, segments.get(i)[1]);
          i++;
        }
        count++;
        r = nextR;
        if (r >= L) {
          break;
        }
      }
      if (count == 0 || r < L) {
        System.out.println(-1);
      } else {
        System.out.println(G - count);
      }
    }
  }
}
