package bMedium;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int m = heights.length, n = heights[0].length;
    boolean[][] pac = new boolean[m][n];
    boolean[][] atl = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      dfs(heights, pac, i, 0);
      dfs(heights, atl, i, n - 1);
    }
    for (int j = 0; j < n; j++) {
      dfs(heights, pac, 0, j);
      dfs(heights, atl, m - 1, j);
    }

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (pac[i][j] && atl[i][j]) {
          res.add(List.of(i, j));
        }
      }
    }
    return res;
  }

  int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  private void dfs(int[][] heights, boolean[][] reachable, int i, int j) {
    reachable[i][j] = true;

    for (int[] d : dirs) {
      int x = i + d[0];
      int y = j + d[1];
      if (x >= 0 && y >= 0 && x < heights.length && y < heights[0].length
          && !reachable[x][y] && heights[x][y] >= heights[i][j]) {
        dfs(heights, reachable, x, y);
      }
    }
  }

}
