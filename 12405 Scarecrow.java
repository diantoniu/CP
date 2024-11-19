import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    int t = 1;
    while (t <= T) {
      int N = Integer.parseInt(br.readLine());
      char[] f = br.readLine().toCharArray();
      boolean[] visited = new boolean[N];
      int result = 0;
      for (int i = 0; i < N; i++) {
        if (f[i] == '.' && !visited[i]) {
          result++;
          visited[i] = true;
          if (i + 1 < N) {
            visited[i + 1] = true;
          }
          if (i + 2 < N) {
            visited[i + 2] = true;
          }
        }
      }
      System.out.println("Case " + t + ": " + result);
      t++;
    }
  }
}
