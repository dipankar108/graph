import java.util.ArrayList;
import java.util.Arrays;

public class DFSTraversal {
    static ArrayList<ArrayList<Integer>> dfs = new ArrayList<>();

    static void constractDFS() {
        for (int i = 0; i <= 5; i++) {
            dfs.add(new ArrayList<>());
        }
        dfs.get(1).add(2);
        dfs.get(1).add(5);
        dfs.get(2).add(1);
        dfs.get(2).add(3);
        dfs.get(2).add(5);
        dfs.get(3).add(2);
        dfs.get(3).add(4);
        dfs.get(4).add(2);
        dfs.get(4).add(3);
        dfs.get(4).add(5);
        dfs.get(5).add(1);
        dfs.get(5).add(4);
    }

    public static void main(String[] args) {
        constractDFS();
        int[] vis = new int[dfs.size() + 1];
        ArrayList<Integer> storeBFS = new ArrayList<>();
        Arrays.fill(vis, -1);
        for (int i = 1; i <= dfs.size() - 1; i++) {
            if (vis[i] == -1) {
                dfsSearch(i, dfs, vis, storeBFS);
            }
        }
        for (int i : storeBFS) {
            System.out.print(i);
        }
    }

    private static void dfsSearch(int i, ArrayList<ArrayList<Integer>> dfs, int[] vis, ArrayList<Integer> storeBFS) {
        vis[i] = 1;
        storeBFS.add(i);
        for (int it : dfs.get(i)) {
            if (vis[it] != 1) {
                vis[it] = 1;
                dfsSearch(it, dfs, vis, storeBFS);
            }
        }
    }

}
