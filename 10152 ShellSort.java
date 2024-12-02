import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = Integer.parseInt(sc.nextLine());
    while (T > 0) {
      T--;
      int n = Integer.parseInt(sc.nextLine());
      String[] originalOrder = new String[n];
      for (int i = 0; i < n; i++) {
        originalOrder[i] = sc.nextLine();
      }

      String[] requiredOrder = new String[n];
      for (int i = 0; i < n; i++) {
        requiredOrder[i] = sc.nextLine();
      }
      HashMap<String, Integer> nameToIndex = new HashMap<>();
      HashMap<Integer, String> indexToName = new HashMap<>();
      for (int i = 0; i < n; i++) {
        nameToIndex.put(requiredOrder[i], i);
        indexToName.put(i, requiredOrder[i]);
      }
      

      int currMax = Integer.MIN_VALUE, maxNotInOrder = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        int index = nameToIndex.get(originalOrder[i]);
        if (currMax > index) {
          maxNotInOrder = Math.max(maxNotInOrder, index);
        }
        currMax = Math.max(currMax, index);
      }

      ArrayList<String> result = new ArrayList<>();
      for (int i = maxNotInOrder; i >= 0; i--) {
        result.add(indexToName.get(i));
      }
      
      for (String s : result) {
        System.out.println(s);
      }
      System.out.println();
    }
  }
}
