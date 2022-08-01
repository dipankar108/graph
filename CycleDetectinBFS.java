import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectinBFS {
    static class Node {
        int child;
        int parent;

        Node(int child, int parent) {
            this.child = child;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> bfs = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            bfs.add(new ArrayList<>());
        }
         constrcutBFS(bfs);
       //constractABFS(bfs);
        boolean det = detectBFS(bfs);
        System.out.print(det);
    }

    private static boolean detectBFS(ArrayList<ArrayList<Integer>> bfs) {
        int vis[] = new int[bfs.size() + 1];
        Arrays.fill(vis, -1);
        for (int i = 1; i < bfs.size(); i++) {
            if (vis[i] == -1) {
                if (isCycle(i, bfs, vis)) return true;
            }
        }
        return false;
    }

    private static boolean isCycle(int i, ArrayList<ArrayList<Integer>> bfs, int[] vis) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(i, -1));
        vis[i] = 1;
        while (!queue.isEmpty()) {
            int child = queue.peek().child;
            int parent = queue.peek().parent;
            queue.remove();
            for (int it : bfs.get(child)) {
                if (vis[it] == -1) {
                    vis[it] = 1;
                    queue.add(new Node(it, child));
                } else if (it != parent) return true;
            }
        }
        return false;
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
        bfs.get(3).add(2);
        bfs.get(3).add(4);
        bfs.get(4).add(3);
        bfs.get(4).add(5);
        bfs.get(5).add(4);
    }
}
