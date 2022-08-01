import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiprateBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> bfs = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            bfs.add(new ArrayList<>());
        }
       // constrcutBFS(bfs);
         constractABFS(bfs);
        boolean det = detectBiprate(bfs);
        System.out.print(det);
    }

    private static boolean detectBiprate(ArrayList<ArrayList<Integer>> bfs) {
        int vis[] = new int[bfs.size() + 1];
        Arrays.fill(vis, -1);
        for (int i = 1; i < bfs.size(); i++) {
            if (vis[i] == -1) {
                if (!isBiprate(i, bfs, vis)) return false;
            }
        }
        return true;
    }

    private static boolean isBiprate(int i, ArrayList<ArrayList<Integer>> bfs, int[] vis) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        vis[i] =0;
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int it : bfs.get(parent)) {
                if (vis[it] == -1) {
                    vis[it] = 1 - vis[parent];
                    queue.add(it);
                } else if (vis[it] == vis[parent]) return false;
            }
        }
        return true;
    }

    private static void constrcutBFS(ArrayList<ArrayList<Integer>> bfs) {
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

    private static void constractABFS(ArrayList<ArrayList<Integer>> bfs) {
        bfs.get(1).add(2);
        bfs.get(2).add(1);
        bfs.get(2).add(3);
        bfs.get(2).add(6);
        bfs.get(3).add(2);
        bfs.get(3).add(4);
        bfs.get(4).add(3);
        bfs.get(4).add(5);
        bfs.get(5).add(4);
        bfs.get(5).add(6);
        bfs.get(5).add(7);
        bfs.get(6).add(2);
        bfs.get(6).add(5);
        bfs.get(7).add(5);
    }
}
