from ..tools.list_node import ListNode


class Solution:

    @staticmethod
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        """
        172ms 25.44%
        13MB 97.03%
        Convert ListNode to str, then convert str to int and add two integer together,
        Convert the sum to ListNode at last.
        """
        node = l1
        res1 = ""
        while node is not None:
            res1 = str(node.val) + res1
            node = node.next

        node = l2
        res2 = ""
        while node is not None:
            res2 = str(node.val) + res2
            node = node.next

        add = str(int(res1) + int(res2))

        l3 = l4 = ListNode(0)
        for index in range(len(add), 0, -1):
            l3.next = ListNode(int(add[index - 1]))
            l3 = l3.next

        return l4.next

    @staticmethod
    def addTwoNumbers2(l1: ListNode, l2: ListNode) -> ListNode:
        """
        152ms 34.54%
        13MB 97.61%
        """
        carry = 0
        l3 = l4 = ListNode(0)

        while l1 or l2 or carry:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            num = val1 + val2 + carry
            carry = 0
            if num // 10 > 0:
                carry = 1
                num = num % 10
            l3.next = ListNode(num)
            l3 = l3.next
            l1 = l1.next if l1 else l1
            l2 = l2.next if l2 else l2

        return l4.next
