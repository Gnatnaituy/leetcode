from python.tools.node import ListNode


def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
    """
    52ms 93.76%
    13.1MB 83.1%
    :param self:
    :param head:
    :param n:
    :return:
    """
    if not head:
        return head

    dummy = ListNode(0)
    dummy.next = head
    fast = dummy

    while n:
        fast = fast.next
        n -= 1

    slow = dummy

    while fast and fast.next:
        fast = fast.next
        slow = slow.next

    slow.next = slow.next.next

    return dummy.next
