import java.util.*;

public class Main {

  public static boolean f(char[][] b, int n, int m, int i, int j, int r, int c) {
    if (i + r - 1 >= n || j + c - 1 >= m) {
      return false;
    }
    for (int k = i; k < i + r; k++) {
      for (int l = j; l < j + c; l++) {
        b[k][l] = (b[k][l] == '0' ? '1' : '0');
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      int n = sc.nextInt(), m = sc.nextInt();
      int r = sc.nextInt(), c = sc.nextInt();
      if (n == 0 && m == 0 && r == 0 && c == 0) {
        break;
      }
      char[][] a = new char[n][m];
      for (int i = 0; i < n; i++) {
        a[i] = sc.next().toCharArray();
      }
      char[][] b = new char[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          b[i][j] = '0';
        }
      }
      int count = 0;
      for (int i = 0; i < n && count >= 0; i++) {
        for (int j = 0; j < m && count >= 0; j++) {
          if (a[i][j] != b[i][j]) {
            if (f(b, n, m, i, j, r, c)) {
              count++;
            } else {
              count = -1;
              break;
            }
          }
        }
      }
      System.out.println(count);
    }
  }
}
