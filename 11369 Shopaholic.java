import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            T--;
            int n = Integer.parseInt(br.readLine());
            Integer[] items = new Integer[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                items[i] = Integer.parseInt(st.nextToken());
            }
            long result = 0;
            Arrays.sort(items, Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                if (i % 3 == 2) {
                    result += items[i];
                }
            }
            System.out.println(result);
        }
    }
}
