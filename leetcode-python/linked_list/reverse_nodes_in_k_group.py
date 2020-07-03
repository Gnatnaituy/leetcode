from tools.node import ListNode


def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
    """
    Stack
    112ms 21.14%
    13.9MB 99.63%
    :param self:
    :param head:
    :param k:
    :return:
    """
    dummy = ListNode(0)
    p = dummy

    while True:
        count = k
        stack = []
        tmp = head

        while count and tmp:
            stack.append(tmp)
            tmp = tmp.next
            count -= 1

        # 注意,目前tmp所在k+1位置
        # 说明剩下的链表不够k个,跳出循环
        if count:
            p.next = head
            break

        # 翻转操作
        while stack:
            p.next = stack.pop()
            p = p.next

        # 与剩下链表连接起来
        p.next = tmp
        head = tmp

    return dummy.next


def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
    """
    尾插法
    :param self:
    :param head:
    :param k:
    :return:
    """
    dummy = ListNode(0)
    dummy.next = head
    pre = dummy
    tail = dummy

    while True:
        count = k
        while count and tail:
            count -= 1
            tail = tail.next

        if not tail:
            break

        head = pre.next

        while pre.next != tail:
            cur = pre.next
            pre.next = cur.next
            cur.next = tail.next
            tail.next = cur

        pre = head
        tail = head

    return dummy.next


def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
    """
    递归
    :param self:
    :param head:
    :param k:
    :return:
    """
    cur = head
    count = 0
    while cur and count!= k:
        cur = cur.next
        count += 1
    if count == k:
        cur = self.reverseKGroup(cur, k)
        while count:
            tmp = head.next
            head.next = cur
            cur = head
            head = tmp
            count -= 1
        head = cur
    return head
