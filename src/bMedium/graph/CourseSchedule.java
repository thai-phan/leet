package bMedium.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> g = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());

    for (int[] p : prerequisites) {
      g.get(p[0]).add(p[1]); // a depends on b
    }

    int[] state = new int[numCourses];
    // 0 = unvisited, 1 = visiting, 2 = visited

    for (int i = 0; i < numCourses; i++) {
      if (state[i] == 0 && hasCycle(i, g, state))
        return false;
    }

    return true;
  }

  private boolean hasCycle(int node, List<List<Integer>> g, int[] state) {
    state[node] = 1; // visiting

    for (int nxt : g.get(node)) {
      if (state[nxt] == 1) return true;      // cycle
      if (state[nxt] == 0 && hasCycle(nxt, g, state))
        return true;
    }

    state[node] = 2; // done
    return false;
  }

}
