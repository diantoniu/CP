import java.util.*;


public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      t--;
      int M = sc.nextInt();
      ArrayList<int[]> segments = new ArrayList<>();
      while (true) {
        int l = sc.nextInt(), r = sc.nextInt();
        if (l == 0 && r == 0) {
          break;
        }
        segments.add(new int[] {l, r});
      }
      segments.sort(Comparator.comparingInt(o -> o[0]));

      ArrayList<int[]> result = new ArrayList<>();
      int i = 0, currentR = 0;
      while (i < segments.size()) {
        if (currentR >= M) {
          break;
        }
        if (segments.get(i)[0] > currentR) {
          break;
        }
        int nextR = currentR, nextSegment = i;
        while (i < segments.size() && segments.get(i)[0] <= currentR) {
          if (segments.get(i)[1] > nextR) {
            nextR = segments.get(i)[1];
            nextSegment = i;
          }
          i++;
        }
        result.add(new int[]{segments.get(nextSegment)[0], segments.get(nextSegment)[1]});
        currentR = nextR;
      }

      if (result.isEmpty() || result.get(result.size() - 1)[1] < M) {
        System.out.println(0);
      } else {
        System.out.println(result.size());
        for (int[] segment : result) {
          System.out.println(segment[0] + " " + segment[1]);
        }
      }
      System.out.println();
    }
  }
}
