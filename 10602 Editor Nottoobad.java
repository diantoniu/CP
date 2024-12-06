import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int Q = sc.nextInt();
    while (Q > 0) {
      Q--;
      int n = sc.nextInt();;
      ArrayList<String> words = new ArrayList<>();
      ArrayList<String> prefix = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        String word = sc.next();
        if (prefix.isEmpty() || word.charAt(0) == prefix.get(0).charAt(0)) {
          prefix.add(word);
        } else {
          words.add(word);
        }
      }

      String firstWord = prefix.get(0);
      int firstWordIndex = 0;
      Collections.sort(prefix);
      Collections.sort(words);
      ArrayList<String> result = new ArrayList<>();
      for (int i = 0; i < prefix.size(); i++) {
        if (prefix.get(i).equals(firstWord)) {
          firstWordIndex = i;
          break;
        }
      }
      result.add(prefix.get(firstWordIndex));

      boolean[] visited = new boolean[prefix.size()];
      visited[firstWordIndex] = true;
      int last = firstWord.length();
      while (last > 0) {
        for (int i = 0; i < prefix.size(); i++) {
          if (prefix.get(i).startsWith(firstWord.substring(0, last)) && !visited[i]) {
            result.add(prefix.get(i));
            visited[i] = true;
          }
        }
        last--;
      }
      result.addAll(words);
      int res = 0;
      String word = "";
      for (int i = 0; i < result.size(); i++) {
        int prefixSize = 0;
        for (int j = 0; j < Math.min(word.length(), result.get(i).length()); j++) {
          if (word.charAt(j) != result.get(i).charAt(j)) {
            break;
          }
          prefixSize++;
        }
        res += result.get(i).length() - prefixSize;
        word = result.get(i);
      }
      System.out.println(res);
      for (int i = 0; i < result.size(); i++) {
        System.out.println(result.get(i));
      }
    }
  }
}
