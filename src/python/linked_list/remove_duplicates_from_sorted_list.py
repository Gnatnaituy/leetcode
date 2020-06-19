from python.tools.node import ListNode


class Solution:

    def deleteDuplicates(self, head: ListNode) -> ListNode:
        """
        100ms 21.85%
        13.3MB 17.24%
        :param head:
        :return:
        """
        if not head:
            return head

        fast = slow = head

        while fast:
            if fast.val != slow.val:
                slow.next = fast
                slow = slow.next
            fast = fast.next

        slow.next = fast

        return head
