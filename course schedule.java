import java.util.*;

class Solution {
    public boolean canFinish(int n, int[][] pre) {
        int[] indegree = new int[n];
        List<Integer>[] graph = new ArrayList[n];

        // init
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // build graph
        for (int[] p : pre) {
            graph[p[1]].add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // add courses with 0 prereq
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int done = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            done++;

            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return done == n;
    }
}