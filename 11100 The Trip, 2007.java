import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      if(n == 0) {
        break;
      }
      ArrayList<Integer> bags = new ArrayList<>();
      HashMap<Integer, Integer> bagsCounts = new HashMap<>();
      int max = 0;
      for (int i = 0; i < n; i++) {
        int val = sc.nextInt();
        bags.add(val);
        bagsCounts.put(val, bagsCounts.getOrDefault(val, 0) + 1);
        max = Math.max(max, bagsCounts.get(val));
      }
      
      Collections.sort(bags);
      ArrayList<ArrayList<Integer>> result = new ArrayList<>();
      for (int i = 0; i < max; i++) {
        result.add(new ArrayList<>());
      }
      for (int bi = 0, ri = 0; bi < n; bi++, ri = (ri + 1) % max) {
        result.get(ri).add(bags.get(bi));
      }
      System.out.println(max);
      for (int i = 0; i < max; i++) {
        for (int j = 0; j < result.get(i).size(); j++) {
          System.out.print(result.get(i).get(j) + (j == result.get(i).size() - 1 ? "" : " "));
        }
        System.out.println();
      }
    }
  }
}
