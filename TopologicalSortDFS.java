import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> dfs = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            dfs.add(new ArrayList<>());
        }
        int[] vis = new int[dfs.size() + 1];
        Arrays.fill(vis, -1);
        // constrcutBFS(bfs);
        constractADFS(dfs);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < dfs.size(); i++) {
            if (vis[i] == -1) {
                topologicalSort(i, dfs, vis, st);
            }
        }
        while (!st.isEmpty()) {
            int val = st.pop();
            System.out.print(val);
        }
    }

    private static void topologicalSort(int node, ArrayList<ArrayList<Integer>> dfs, int[] vis, Stack<Integer> st) {
        if (vis[node] == -1) vis[node] = 1;
        for (int it : dfs.get(node)) {
            if (vis[it] == -1) {
                vis[it] = -1;
                topologicalSort(it, dfs, vis, st);
            }
        }
        st.push(node);
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
        dfs.get(2).add(3);
        dfs.get(3).add(1);
        dfs.get(4).add(0);
        dfs.get(4).add(1);
        dfs.get(5).add(0);
        dfs.get(5).add(2);
//        dfs.get(1).add(2);
//        dfs.get(2).add(1);
//        dfs.get(2).add(3);
//        dfs.get(2).add(6);
//        dfs.get(3).add(2);
//        dfs.get(3).add(4);
//        dfs.get(4).add(3);
//        dfs.get(4).add(5);
//        dfs.get(5).add(4);
//        dfs.get(5).add(6);
//        dfs.get(5).add(7);
//        dfs.get(6).add(2);
//        dfs.get(6).add(5);
//        dfs.get(7).add(5);
    }
}
