import threading
from typing import Callable


class Method1:
    """
    100ms/6.00%/13.9MB/100.00%
    """
    def __init__(self, n):
        self.n = n
        self.semaphore1 = threading.Semaphore(1)
        self.semaphore2 = threading.Semaphore(0)

    def foo(self, printFoo: 'Callable[[], None]') -> None:
        for i in range(self.n):
            self.semaphore1.acquire()
            printFoo()
            self.semaphore2.release()

    def bar(self, printBar: 'Callable[[], None]') -> None:
        for i in range(self.n):
            self.semaphore2.acquire()
            printBar()
            self.semaphore1.release()
