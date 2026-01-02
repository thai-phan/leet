package bMedium.review;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom2_253 {
  public int minMeetingRooms(int[][] intervals) {

    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) {
      return 0;
    }

    Integer[] startArr = new Integer[intervals.length];
    Integer[] endArr = new Integer[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      startArr[i] = intervals[i][0];
      endArr[i] = intervals[i][1];
    }

    Arrays.sort(endArr, Comparator.comparingInt(a -> a));
    Arrays.sort(startArr, Comparator.comparingInt(a -> a));

    // The two pointers in the algorithm: e_ptr and s_ptr.
    int startIdx = 0;
    int endIdx = 0;

    // Variables to keep track of maximum number of rooms used.
    int usedRooms = 0;

    // Iterate over intervals.
    while (startIdx < intervals.length) {

      // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
      if (startArr[startIdx] >= endArr[endIdx]) {
        usedRooms -= 1;
        endIdx += 1;
      }

      // We do this irrespective of whether a room frees up or not.
      // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
      // remain the same in that case. If no room was free, then this would increase used_rooms
      usedRooms += 1;
      startIdx += 1;
    }

    return usedRooms;
  }
}
