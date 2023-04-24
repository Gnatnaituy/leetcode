#
# @lc app=leetcode.cn id=1114 lang=python3
#
# [1114] 按序打印
#

# @lc code=start
import threading


class Foo:
    def __init__(self):
        self.locks = (threading.Lock(), threading.Lock())
        self.locks[0].acquire()
        self.locks[1].acquire()


    def first(self, printFirst: 'Callable[[], None]') -> None:
        printFirst()
        self.locks[0].release()


    def second(self, printSecond: 'Callable[[], None]') -> None:
        with self.locks[0]:
            printSecond()
            self.locks[1].release()


    def third(self, printThird: 'Callable[[], None]') -> None:
        with self.locks[1]:
            printThird()
# @lc code=end

