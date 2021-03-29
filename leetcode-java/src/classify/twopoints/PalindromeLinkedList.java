package classify.twopoints;

import tools.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yutiantang
 * @create 2021/3/28 6:45 PM
 */
public class PalindromeLinkedList {

    /**
     * 10ms     18.53%
     * 50.4MB   19.09%
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            if (nums.get(left).equals(nums.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
