package lc;

public class JumpGameII {
    public static void main(String[] args) {

        ListNode a1 = new ListNode(6);
        ListNode a2 = new ListNode(5, a1);
        ListNode a3 = new ListNode(4, a2);
        ListNode b1 = new ListNode(3, a3);
        ListNode b2 = new ListNode(2, b1);
        ListNode b3 = new ListNode(1, b2);
//

        int[] fruits = {2, 3, 1, 1, 4};

        _jump(fruits);
    }

    //Input: nums = [2,3,1,1,4]
    //Output: 2
    //Explanation: The minimum number of jumps to reach the last index is 2.
    // Jump 1 step from index 0 to 1, then 3 steps to the last index.

//    public static int jump(int[] nums) {
//        int len = nums.length;
//        int step = 0;
//        int cur = 0;
//        while (cur < len) {
//            int jumpVal = nums[cur];
//            for (int i = 0; i < jumpVal; i++) {
//
//            }
//
//            step++;
//            if (nums[cur] > len - cur) {
//                return step + 1;
//            }
//        }
//        return 0;
//    }

    public static int _jump(int[] A) {
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;

        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
