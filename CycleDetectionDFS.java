import java.util.ArrayList;
import java.util.Arrays;

public class CycleDetectionDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dfs = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            dfs.add(new ArrayList<>());
        }
         constrcutDFS(dfs);
        //constractADFS(dfs);
        boolean det = detectDFS(dfs);
        System.out.print(det);
    }

    private static boolean detectDFS(ArrayList<ArrayList<Integer>> dfs) {
        int vis[] = new int[dfs.size() + 1];
        Arrays.fill(vis, -1);
        for (int i = 1; i < dfs.size(); i++) {
            if (vis[i] == -1) {
                if (isCycle(i, dfs, vis, -1)) return true;
            }
        }
        return false;
    }

    private static boolean isCycle(int i, ArrayList<ArrayList<Integer>> dfs, int[] vis, int parent) {
        vis[i] = 1;
        for (int it : dfs.get(i)) {
            if (vis[it] == -1) {
                return isCycle(it, dfs, vis, i);
            } else if (it != parent) return true;
        }
        return false;
    }

    private static void constrcutDFS(ArrayList<ArrayList<Integer>> bfs) {
        bfs.get(1).add(2);
        bfs.get(2).add(1);
        bfs.get(2).add(4);
        bfs.get(3).add(5);
        bfs.get(4).add(2);
        bfs.get(5).add(3);
        bfs.get(5).add(6);
        bfs.get(5).add(10);
        bfs.get(6).add(5);
        bfs.get(6).add(7);
        bfs.get(7).add(6);
        bfs.get(7).add(8);
        bfs.get(8).add(7);
        bfs.get(8).add(9);
        bfs.get(8).add(11);
        bfs.get(9).add(8);
        bfs.get(9).add(10);
        bfs.get(10).add(5);
        bfs.get(10).add(9);
    }

    private static void constractADFS(ArrayList<ArrayList<Integer>> bfs) {
        bfs.get(1).add(2);
        bfs.get(2).add(1);
        bfs.get(2).add(3);
        bfs.get(3).add(2);
        bfs.get(3).add(4);
        bfs.get(4).add(3);
        bfs.get(4).add(5);
        bfs.get(5).add(4);
    }
}
