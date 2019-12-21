from src.python.tools.list_node import ListNode


def mergeTwoList(self, l1: ListNode, l2: ListNode) -> ListNode:
    """
    84ms 28.26%
    12.8MB 99.29%
    :param l2:
    :param l1:
    :param self:
    """
    prehead = ListNode(-1)

    prev = prehead
    while l1 and l2:
        if l1.val <= l2.val:
            prev.next = l1
            l1 = l1.next
        else:
            prev.next = l2
            l2 = l2.next
        prev = prev.next

    prev.next = l1 if l1 is not None else l2

    return prehead.next


def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
    """
    92ms 23.08%
    13.3MB 17.61%
    :param self:
    :param l1:
    :param l2:
    :return:
    """
    cur = res = ListNode(0)

    while l1 or l2:
        if l1 is not None and (l2 is None or l1.val <= l2.val):
            cur.next = l1
            l1 = l1.next
        else:
            cur.next = l2
            l2 = l2.next
        cur = cur.next

    return res.next
