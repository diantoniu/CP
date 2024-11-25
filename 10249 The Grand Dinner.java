import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int M = sc.nextInt(), T = sc.nextInt();
      if (M == 0 && T == 0) {
        break;
      }
      int[][] m = new int[M][2];
      for (int i = 0; i < M; i++) {
        m[i][0] = i;
        m[i][1] = sc.nextInt();
      }

      int[][] t = new int[T][2];
      for (int i = 0; i < T; i++) {
        t[i][0] = i;
        t[i][1] = sc.nextInt();
      }

      Arrays.sort(m, (o1, o2) -> {
        return Integer.compare(o2[1], o1[1]);
      });

      Arrays.sort(t, (o1, o2) -> {
        return Integer.compare(o1[1], o2[1]);
      });

      int result = 1;
      int firstAvailableTable = 0;
      HashMap<Integer, int[]> arrangements = new HashMap<>();
      for (int i = 0; i < M; i++) {
        int teamSize = m[i][1];
        if (teamSize > T) {
          result = 0;
          break;
        }
        int teamNumber = m[i][0];
        int[] teamArrangement = new int[teamSize];
        int teamMemberIndex = 0;
        for (int j = firstAvailableTable; j < T && teamMemberIndex < teamSize; j++) {
          int tableNumber = t[j][0];
          int tableSize = t[j][1];
          if (tableSize > 0) {
            teamArrangement[teamMemberIndex] = tableNumber;
            t[j][1]--;
            teamMemberIndex++;
          }
          if (tableSize == 0) {
            firstAvailableTable++;
          }
        }
        if (teamMemberIndex < teamSize) {
          result = 0;
          break;
        }
        arrangements.put(teamNumber, teamArrangement);
      }

      System.out.println(result);
      if (result > 0) {
        for (int i = 0; i < M; i++) {
          int[] team = arrangements.get(i);
          for (int j = 0; j < team.length; j++) {
            System.out.print((team[j] + 1) + (j == team.length - 1 ? "\n" : " "));
          }
        }
      }
    }
  }
}
