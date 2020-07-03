from tools.node import ListNode


def mergeKLists(self, lists: list[ListNode]) -> ListNode:
    """
    84ms 98.49%
    16.4MB 73.32%
    :param self:
    :param lists:
    :return:
    """
    r, n, p = [], lists and lists.pop(), None

    while lists or n:
        r[len(r):], n = ([n], n.next or lists and lists.pop()) if n else ([], lists.pop())

    for n in sorted(r, key=lambda x: x.val, reverse=True):
        n.next, p = p, n

    return n if r else []
