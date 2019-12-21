from python.tools.list_node import ListNode


def swapPairs(self, head: ListNode) -> ListNode:
    """
    88ms 7.43%
    13MB 89.91%
    和32秒那个最快的思路是一样的......
    :param self:
    :param head:
    :return:
    """
    cur = ListNode(0)
    cur.next = head
    head = cur

    while cur and cur.next and cur.next.next:
        temp = cur.next.next
        cur.next.next = temp.next
        temp.next = cur.next
        cur.next = temp
        cur = cur.next.next

    return head.next


def swapPairs2(self, head: ListNode) -> ListNode:
    """
    24ms
    """
    if not head or not head.next:
        return head
        
    tmp = head.next
    head.next = self.swapPairs(head.next.next)
    tmp.next = head

    return tmp
