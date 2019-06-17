from python.tools.list_node import ListNode


def rotateRight(self, head: ListNode, k: int) -> ListNode:
    """
    72ms 36.76%
    13MB 95.80%
    :param self:
    :param head:
    :param k:
    :return:
    """
    if not head or not head.next:
        return head

    old_tail = head
    length = 1
    while old_tail.next:
        old_tail = old_tail.next
        length += 1
    # make it circular linked list
    old_tail.next = head

    new_tail = head
    for i in range(length - k % length - 1):
        new_tail = new_tail.next
    new_head = new_tail.next

    new_tail.next = None

    return new_head


