import java.util.*;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> bfs = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            bfs.add(new ArrayList<>());
        }
        int[] store = new int[bfs.size()];
        // constrcutBFS(bfs);
        constractADFS(bfs);
        int[] indegree = new int[bfs.size()];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bfs.size(); i++) {
            for (int it : bfs.get(i)) {
                indegree[it]++;
            }
        }
        int idx = 0;
        for (int i : indegree) {
            if (i == 0) queue.add(idx);
            idx++;
        }

        topologicalSort(bfs, store, queue, indegree);
        for (int i : store) {
            System.out.print(i);
        }
    }

    private static void topologicalSort(ArrayList<ArrayList<Integer>> bfs, int[] store, Queue<Integer> queue, int[] indegree) {
        int idx = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            store[idx] = node;
            idx++;
            for (int it : bfs.get(node)) {
                if (indegree[it] != 0) indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }
    }

    private static void constrcutDFS(ArrayList<ArrayList<Integer>> bfs) {
        bfs.get(2).add(1);
        bfs.get(1).add(2);
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
        bfs.get(2).add(3);
        bfs.get(3).add(1);
        bfs.get(4).add(0);
        bfs.get(4).add(1);
        bfs.get(5).add(0);
        bfs.get(5).add(2);
//        bfs.get(1).add(2);
//        bfs.get(2).add(1);
//        bfs.get(2).add(3);
//        bfs.get(2).add(6);
//        bfs.get(3).add(2);
//        bfs.get(3).add(4);
//        bfs.get(4).add(3);
//        bfs.get(4).add(5);
//        bfs.get(5).add(4);
//        bfs.get(5).add(6);
//        bfs.get(5).add(7);
//        bfs.get(6).add(2);
//        bfs.get(6).add(5);
//        bfs.get(7).add(5);
    }
}
