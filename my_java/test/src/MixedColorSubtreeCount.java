import java.util.*;

public class MixedColorSubtreeCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String colors = scanner.next();

        List<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        int[] redCount = new int[n + 1];
        int[] blackCount = new int[n + 1];

        dfs(1, 0, tree, colors, redCount, blackCount);

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (redCount[i] > 0 && blackCount[i] > 0) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int node, int parent, List<Integer>[] tree, String colors, int[] redCount, int[] blackCount) {
        if (colors.charAt(node - 1) == 'R') {
            redCount[node]++;
        } else {
            blackCount[node]++;
        }

        for (int child : tree[node]) {
            if (child != parent) {
                dfs(child, node, tree, colors, redCount, blackCount);
                redCount[node] += redCount[child];
                blackCount[node] += blackCount[child];
            }
        }
    }
}

