import java.util.ArrayList;
import java.util.Arrays;

public class BiprateDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dfs = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dfs.add(new ArrayList<>());
        }
        int[] color = new int[dfs.size() + 1];
        Arrays.fill(color, -1);
        // constrcutBFS(bfs);
        constractADFS(dfs);
        boolean det = detectBiprate(dfs, color);
        System.out.print(det);
    }

    private static boolean detectBiprate(ArrayList<ArrayList<Integer>> dfs, int[] color) {
        for (int i = 0; i < dfs.size(); i++) {
            if (color[i] == -1) {
                if (!checkBipartite(i, dfs, color)) return false;
            }
        }
        return true;
    }

    private static boolean checkBipartite(int parent, ArrayList<ArrayList<Integer>> dfs, int[] color) {
        if (color[parent] == -1) color[parent] = 1;
        for (int node : dfs.get(parent)) {
            if (color[node] == -1) {
                color[node] = 1 - color[parent];
                if (!checkBipartite(node, dfs, color)) return false;
            } else if (color[node] == color[parent]) return false;
        }
        return true;
    }

    private static void constrcutDFS(ArrayList<ArrayList<Integer>> dfs) {
        dfs.get(2).add(1);
        dfs.get(1).add(2);
        dfs.get(2).add(4);
        dfs.get(3).add(5);
        dfs.get(4).add(2);
        dfs.get(5).add(3);
        dfs.get(5).add(6);
        dfs.get(5).add(10);
        dfs.get(6).add(5);
        dfs.get(6).add(7);
        dfs.get(7).add(6);
        dfs.get(7).add(8);
        dfs.get(8).add(7);
        dfs.get(8).add(9);
        dfs.get(8).add(11);
        dfs.get(9).add(8);
        dfs.get(9).add(10);
        dfs.get(10).add(5);
        dfs.get(10).add(9);
    }

    private static void constractADFS(ArrayList<ArrayList<Integer>> dfs) {
        dfs.get(1).add(2);
        dfs.get(2).add(1);
        dfs.get(2).add(3);
        dfs.get(2).add(6);
        dfs.get(3).add(2);
        dfs.get(3).add(4);
        dfs.get(4).add(3);
        dfs.get(4).add(5);
        dfs.get(5).add(4);
        dfs.get(5).add(6);
        dfs.get(5).add(7);
        dfs.get(6).add(2);
        dfs.get(6).add(5);
        dfs.get(7).add(5);
    }
}
