import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionTopologicalSort {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> bfs = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            bfs.add(new ArrayList<>());
        }
        constrcutDFS(bfs);
        // constractADFS(bfs);
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[bfs.size() + 1];
        for (int i = 0; i < bfs.size(); i++) {
            for (int it : bfs.get(i)) {
                indegree[it]++;
            }
        }
        int idx = 0;
        for (int it : indegree) {
            if (it == 0) queue.add(idx);
            idx++;
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            cnt++;
            for (int it : bfs.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) queue.add(it);
            }
        }
        if (cnt == bfs.size()) {
            System.out.print("No cycle");
        } else {
            System.out.print("Cycle detected");
        }
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
        bfs.get(2).add(3);
        bfs.get(3).add(1);
        bfs.get(4).add(0);
        bfs.get(4).add(1);
        bfs.get(5).add(0);
        bfs.get(5).add(2);
    }

}
