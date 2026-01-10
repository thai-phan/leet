package bMedium.graph;

import java.util.*;

// 28 / 47 testcases passed
public class CourseSchedule_2 {
  public static void main(String[] args) {
    CourseSchedule_2 cs2 = new CourseSchedule_2();
    int numCourses = 9;
    int[][] prerequisites = {{1, 0}, {2, 0}, {2, 1}, {0, 8}, {5, 4}, {5, 3}, {6, 8}, {7, 8}};
    int[] order = cs2.findOrderBFS(numCourses, prerequisites);
    System.out.print("Course Order: ");
    for (int course : order) {
      System.out.print(course + " ");
    }
  }

  static int UNVISITED = 0;
  static int VISITING = 1;
  static int VISITED = 2;

//  boolean isPossibleDFS;
//  Map<Integer, List<Integer>> adjList;
//  List<Integer> topologicalOrder;
//
//  public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
//    isPossibleDFS = true;
//    Map<Integer, Integer> color = new HashMap<>();
//    adjList = new HashMap<>();
//    topologicalOrder = new ArrayList<>();
//
//    for (int i = 0; i < numCourses; i++) {
//      color.put(i, UNVISITED);
//    }
//
//    // Create the adjacency list representation of the graph
//    for (int[] prerequisite : prerequisites) {
//      int after = prerequisite[0];
//      int before = prerequisite[1];
//      adjList.computeIfAbsent(before, k -> new ArrayList<>()).add(after);
//    }
//
//    // If the node is unprocessed, then call dfs on it.
//    for (int i = 0; i < numCourses; i++) {
//      if (color.get(i) == UNVISITED) {
//        dfs(i, color);
//        System.out.println("After DFS of node " + i + ", topologicalOrder: " + topologicalOrder);
//      }
//    }
//
//    int[] order;
//    if (isPossibleDFS) {
//      order = new int[numCourses];
//      for (int i = 0; i < numCourses; i++) {
//        order[i] = topologicalOrder.get(numCourses - i - 1);
//      }
//    } else {
//      order = new int[0];
//    }
//
//    return order;
//  }
//
//  private void dfs(int node, Map<Integer, Integer> color) {
//    if (!isPossibleDFS) {
//      return;
//    }
//    color.put(node, VISITING);
//    if (adjList.containsKey(node)) {
//      for (int neighbor : adjList.get(node)) {
//        if (color.get(neighbor) == UNVISITED) {
//          dfs(neighbor, color);
//        } else if (color.get(neighbor) == VISITING) {
//          // An edge to a GRAY vertex represents a cycle
//          isPossibleDFS = false;
//        }
//      }
//    }
//
//    // Recursion ends. We mark it as black
//    color.put(node, VISITED);
//    topologicalOrder.add(node);
//  }

  Map<Integer, List<Integer>> adjMap;
  int[] color;

  public int[] findOrderBFS(int numCourses, int[][] prerequisites) {

    adjMap = new HashMap<>();
    int[] inDegreeArr = new int[numCourses];
    color = new int[numCourses];

    for (int[] pre : prerequisites) {
      int after = pre[0];
      int before = pre[1];
      adjMap.computeIfAbsent(before, k -> new ArrayList<>()).add(after);
      inDegreeArr[after]++;
    }
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < inDegreeArr.length; i++) {
      if (inDegreeArr[i] == 0) {
        queue.offer(i);
      }
    }
    boolean isCircle = false;
    List<Integer> outList = new ArrayList<>();
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      outList.add(cur);
      color[cur] = VISITING;
      if (isCircle) {
        break;
      }

      for (int next : adjMap.getOrDefault(cur, new ArrayList<>())) {
        if (color[next] == UNVISITED) {
          queue.offer(next);
        }
//        else if (color[next] == VISITING) {
//          isCircle = true;
//        }
      }
    }
    if (isCircle) {
      return new int[]{};
    }
    int[] out = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      out[i] = outList.get(i);
    }
    return out;
  }

}
