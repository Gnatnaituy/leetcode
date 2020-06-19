from python.tools.node import ListNode


def partition(head: ListNode, x: int) -> ListNode:
    """
    68ms 34.59%
    12.9MB 98.15%
    :param head:
    :param x:
    :return:
    """
    before = before_head = ListNode(0)
    after = after_head = ListNode(0)

    while head:
        # If the original list node is lesser than the given x,
        # assign it to the before list.
        if head.val < x:
            before.next = head
            before = before.next
        else:
            # If the original list node is greater or equal to the given x,
            # assign it to the after list.
            after.next = head
            after = after.next

        # move ahead in the original list
        head = head.next

    # Last node of "after" list would also be ending node of the reformed list
    after.next = None
    # Once all the nodes are correctly assigned to the two lists,
    # combine them to form a single list which would be returned.
    before.next = after_head.next

    return before_head.next
