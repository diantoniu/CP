import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int caseN = 0;
    while(T > 0) {
      T--;
      caseN++;
      int n = sc.nextInt(), m = sc.nextInt();
      HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
      for (int i = 0; i < m; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        if (!map.containsKey(u)) {
          map.put(u, new HashSet<>());
        }
        if (!map.containsKey(v)) {
          map.put(v, new HashSet<>());
        }
        map.get(u).add(v);
        map.get(v).add(u);
      }
      ArrayList<Integer> class1 = new ArrayList<>();
      ArrayList<Integer> class2 = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
        int class1T = 0, class2T = 0;
        for (int j : class1) {
          if (map.containsKey(j) && map.get(j).contains(i)) {
            class1T++;
          }
        }
        for (int j : class2) {
          if (map.containsKey(j) && map.get(j).contains(i)) {
            class2T++;
          }
        }
        if (class1T < class2T) {
          class1.add(i);
        } else {
          class2.add(i);
        }
      }
      int class1T = 0;
      for (int i: class1) {
        for (int j: class1) {
          if (map.containsKey(i) && map.get(i).contains(j)) {
            class1T++;
          }
        }
      }

      int class2T = 0;
      for (int i: class2) {
        for (int j: class2) {
          if (map.containsKey(i) && map.get(i).contains(j)) {
            class2T++;
          }
        }
      }
      class1T /= 2;
      class2T /= 2;

      int half = m / 2;
      if ((class1T + class2T) > half) {
        System.out.println("Case #" + caseN + ": Impossible");
        System.out.println();
      } else {
        System.out.println("Case #" + caseN + ": " + class1.size());
        for (int i = 0; i < class1.size(); i++) {
          System.out.print(class1.get(i) + ((i + 1) == class1.size() ? "\n" : " "));
        }
      }
    }
  }
}
