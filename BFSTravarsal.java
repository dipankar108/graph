import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTravarsal {
    static ArrayList<ArrayList<Integer>> bfs = new ArrayList<>();

    static void constractBFS() {
        for (int i = 0; i <= 5; i++) {
            bfs.add(new ArrayList<>());
        }
        bfs.get(1).add(2);
        bfs.get(1).add(5);
        bfs.get(2).add(1);
        bfs.get(2).add(3);
        bfs.get(2).add(5);
        bfs.get(3).add(2);
        bfs.get(3).add(4);
        bfs.get(4).add(2);
        bfs.get(4).add(3);
        bfs.get(4).add(5);
        bfs.get(5).add(1);
        bfs.get(5).add(4);
    }

    public static void main(String[] args) {
        constractBFS();
        int[] vis = new int[bfs.size() + 1];
        ArrayList<Integer> storeBFS = new ArrayList<>();
        Arrays.fill(vis, -1);
        for (int i = 1; i <= bfs.size() - 1; i++) {
            if (vis[i] == -1) {
                bfsSearch(i, bfs, vis, storeBFS);
            }
        }
        for (int i : storeBFS) {
            System.out.print(i);
        }
    }

    private static void bfsSearch(int i, ArrayList<ArrayList<Integer>> bfs, int[] vis, ArrayList<Integer> storeBFS) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        vis[i] = 1;
        storeBFS.add(i);
        while (!queue.isEmpty()) {
            int val = queue.poll();
            for (int it : bfs.get(val)) {
                if (vis[it] != 1) {
                    storeBFS.add(it);
                    vis[it] = 1;
                    queue.offer(it);
                }
            }
        }
    }
}
