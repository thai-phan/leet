package bMedium;

public class UnionFind {
  public boolean validTree(int n, int[][] edges) {
    if (edges.length != n - 1) return false;

    int[] parents = new int[n];

    for (int i = 0; i < n; i++) parents[i] = i;
    for (int[] edge : edges) {
      // if(firstNode==secondNode) continue;
      int firstParent = find(parents, edge[0]);
      int secondParent = find(parents, edge[1]);
      if (firstParent == secondParent) return false;
      union(parents, firstParent, secondParent);
    }
    // int zeroParent = find(parents,0);
    // //这个是出来零散的情况
    // for(int i = 1; i<n; i++){
    //     if(find(parents,i)!=zeroParent) return false;
    // }
    return true;
  }

  public void union(int[] parents, int i, int j) {
    parents[i] = j;
  }

  public int find(int[] parents, int i) {
    if (parents[i] != i) {
      parents[i] = find(parents, parents[i]);
    }
    return parents[i];
  }

}
