import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void f(char[][] a, int n,  int i, int j) {
    if (j == n) {
      return;
    }
    if (i == n) {
      f(a, n, 0, j + 1);
      return;
    }
    if (a[i][j] != '.') {
      f(a, n, i + 1, j);
      return;
    }

    int[] I = {-1, 1, 0, 0};
    int[] J = {0, 0, -1, 1};

    HashSet<Character> letters = new HashSet<>();
    for (int k = 0; k < 4; k++) {
      int ii = I[k];
      int jj = J[k];
      if ((i + ii < n) && (i + ii >= 0) && (j + jj < n) && (j + jj >= 0)) {
        letters.add(a[i + ii][j + jj]);
      }
    }

    for (int k = 0; k < 26; k++) {
      if (!letters.contains((char)(k + 'A'))) {
        a[i][j] = (char) (k + 'A');
        break;
      }
    }
    f(a, n,i + 1, j);
  }
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = sc.nextInt();
    int caseN = 0;
    while(T > 0) {
      T--;
      caseN++;
      int n = sc.nextInt();
      char[][] a = new char[n][n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.next().toCharArray();
      }
      f(a, n, 0, 0);
      bw.write(("Case " + caseN + ":\n"));
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          bw.write(a[i][j] + (j == n - 1 ? "\n": ""));
        }
      }
    }
    bw.flush();
  }
}
