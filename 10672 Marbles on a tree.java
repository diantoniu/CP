import java.util.*;

public class Main {
    public static int result;
    public static int[] f(ArrayList<ArrayList<Integer>> tree, int[] marbles, int v) {
        int have = 0, need = 0;
        for (int i = 0; i < tree.get(v).size(); i++) {
            int[] localRes = f(tree, marbles, tree.get(v).get(i));
            have += localRes[0];
            need += localRes[1];
        }
        have += marbles[v];
        need += 1;
        int coverNeed = Math.min(have, need);
        have -= coverNeed;
        need -= coverNeed;
        result += have + need;
        return new int[] {have, need};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        while (true) {
            ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] marbles = new int[n];
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            for (int i = 0; i < n; i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                int vertex = sc.nextInt() - 1;
                marbles[vertex] = sc.nextInt();
                int childrens = sc.nextInt();
                for (int j = 0; j < childrens; j++) {
                    int child = sc.nextInt() - 1;
                    tree.get(vertex).add(child);
                    parent[child] = vertex;
                }
            }
            
            int root = -1;
            for (int i = 0; i < n; i++) {
                if (parent[i] == -1) {
                    root = i;
                }
            }
            result = 0;
            f(tree, marbles, root);
            System.out.println(result);
        }
    }
}
