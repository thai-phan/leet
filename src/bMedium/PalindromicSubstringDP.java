package bMedium;

public class PalindromicSubstringDP {
  public int countSubstrings(String s) {
    char[] data = s.toCharArray();
    int n = data.length;
    int count = 0;

    int central = 0;
    while (central < n) {
      char cc = data[central];
      int old = central;

      while (central < n && data[central] == cc) {
        central++;
      }
      int len = central - old;
      count += (len * len + len) / 2;
      int right = central;
      int left = old - 1;
      while (left >= 0 && right < n) {
        if (data[left] == data[right]) {
          left--;
          count++;
          right++;
        } else break;
      }
    }
    return count;
  }
}
