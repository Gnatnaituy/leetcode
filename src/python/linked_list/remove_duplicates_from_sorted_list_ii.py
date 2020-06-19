from python.tools.node import ListNode


def deleteDuplicates(self, head: ListNode) -> ListNode:
    """
    84ms 31.42%
    12.9MB 99.67%
    fast and slow pointer
    :param self:
    :param head:
    :return:
    """
    if not head or not head.next:
        return head

    dummy = ListNode(0)
    dummy.next = head
    slow = dummy
    fast = dummy.next

    while fast:
        if fast.next and fast.next.val == fast.val:
            tmp = fast.val
            while fast and tmp == fast.val:
                fast = fast.next
        else:
            slow.next = fast
            slow = fast
            fast = fast.next

    slow.next = fast

    return dummy.next


def deleteDuplicates2(self, head: ListNode) -> ListNode:
    """
    recursive
    :param self:
    :param head:
    :return:
    """
    if not head:
        return head

    if head.next and head.val == head.next.val:
        while head.next and head.val == head.next.val:
            head = head.next
        return self.deleteDuplicates(head.next)
    else:
        head.next = self.deleteDuplicates(head.next)

    return head
