package bMedium;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticThai {
  public static void main(String[] args) {
    int[][] heights = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };
    PacificAtlanticThai pa = new PacificAtlanticThai();
    List<List<Integer>> result = pa.pacificAtlantic(heights);
    System.out.println("result = " + result);
  }

  int[][] pac;
  int[][] alt;
  int[][] visited;

  public List<List<Integer>> pacificAtlantic(int[][] heights) {

    List<List<Integer>> ll = new ArrayList<>();
    int r = heights.length;
    int c = heights[0].length;
    pac = new int[r][c];
    alt = new int[r][c];

    visited = new int[r][c];

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (i == 1 && j == 3) {
          System.out.println("aaa");
        }
        boolean isP = checkP(heights, i, j, heights[i][j]);
        boolean isA = checkA(heights, i, j, heights[i][j]);
        if (isP && isA) {
          ll.add(List.of(i, j));
        }
      }
    }
    return ll;
  }

  public boolean checkP(int[][] heights, int i, int j, int val) {
    if (i < 0 || j < 0 || i > heights.length - 1 || j > heights[0].length - 1) {
      return false;
    }
    if (heights[i][j] > val) {
      return false;
    }
    if (pac[i][j] == -1) {
      return false;
    }
    if (pac[i][j] == 1) {
      return true;
    }
    if (i == 0 || j == 0) {
      pac[i][j] = 1;
      return true;
    }
    if (visited[i][j] == 1) {
      return false;
    }
    visited[i][j] = 1;
    boolean a1 = checkP(heights, i - 1, j, heights[i][j]);
    boolean a2 = checkP(heights, i, j - 1, heights[i][j]);
    boolean a3 = checkP(heights, i + 1, j, heights[i][j]);
    boolean a4 = checkP(heights, i, j + 1, heights[i][j]);
    visited[i][j] = 0;
    if (a1 || a2 || a3 || a4) {
      pac[i][j] = 1;
      return true;
    } else {
      pac[i][j] = -1;
      return false;
    }
  }

  public boolean checkA(int[][] heights, int i, int j, int val) {
    if (i < 0 || j < 0 || i > heights.length - 1 || j > heights[0].length - 1) {
      return false;
    }
    if (heights[i][j] > val) {
      return false;
    }
    if (alt[i][j] == -1) {
      return false;
    }
    if (alt[i][j] == 1) {
      return true;
    }
    if (i == heights.length - 1 || j == heights[0].length - 1) {
      alt[i][j] = 1;
      return true;
    }
    if (visited[i][j] == 1) {
      return false;
    }
    visited[i][j] = 1;
    boolean a1 = checkA(heights, i + 1, j, heights[i][j]);
    boolean a2 = checkA(heights, i, j + 1, heights[i][j]);
    boolean a3 = checkA(heights, i - 1, j, heights[i][j]);
    boolean a4 = checkA(heights, i, j - 1, heights[i][j]);
    visited[i][j] = 0;
    if (a1 || a2 || a3 || a4) {
      alt[i][j] = 1;
      return true;
    } else {
      alt[i][j] = -1;
      return false;
    }
  }

}
