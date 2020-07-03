import queue
import threading
from collections import Callable


class Method1:
    """
    2316ms/11.35%/13.9MB/100.00%
    #1 while循环法 用while循环卡住执行顺序，并不断监控目标，直到目标符合条件时才跳出当前断点继续执行后续语句。
    """
    def __init__(self):
        self.t = 0

    def first(self, printFirst: 'Callable[[], None]') -> None:
        printFirst()
        self.t = 1

    def second(self, printSecond: 'Callable[[], None]') -> None:
        while self.t != 1:
            pass
        printSecond()
        self.t = 2

    def third(self, printThird: 'Callable[[], None]') -> None:
        while self.t != 2:
            pass
        printThird()


class Method2:
    """
    52ms/62.22%/14MB/100.00%
    #2 Condition条件对象法
    """
    def __init__(self):
        self.condition = threading.Condition()
        self.t = 0

    def first(self, printFirst: 'Callable[[], None]') -> None:
        self.res(0, printFirst)

    def second(self, printSecond: 'Callable[[], None]') -> None:
        self.res(1, printSecond)

    def third(self, printThird: 'Callable[[], None]') -> None:
        self.res(2, printThird)

    def res(self, val: int, func: 'Callable[[], None]') -> None:
        with self.condition:
            self.condition.wait_for(lambda: val == self.t)
            func()
            self.t += 1
            self.condition.notify_all()


class Method3:
    """
    40ms/96.13%/13.8MB/100.00%
    #3 Lock锁对象法
    """
    def __init__(self):
        self.lock1 = threading.Lock()
        self.lock1.acquire()
        self.lock2 = threading.Lock()
        self.lock2.acquire()

    def first(self, printFirst: 'Callable[[], None]') -> None:
        printFirst()
        self.lock1.release()

    def second(self, printSecond: 'Callable[[], None]') -> None:
        self.lock1.acquire()
        printSecond()
        self.lock2.release()

    def third(self, printThird: 'Callable[[], None]') -> None:
        self.lock2.acquire()
        printThird()


class Method4:
    """
    56ms/47.26%/13.8MB/100.00%
    #4 Semaphore信号量对象法
    """
    def __init__(self):
        self.semaphore1 = threading.Semaphore(0)
        self.semaphore2 = threading.Semaphore(0)

    def first(self, printFirst: 'Callable[[], None]') -> None:
        printFirst()
        self.semaphore1.release()

    def second(self, printSecond: 'Callable[[], None]') -> None:
        self.semaphore1.acquire()
        printSecond()
        self.semaphore2.release()

    def third(self, printThird: 'Callable[[], None]') -> None:
        self.semaphore2.acquire()
        printThird()


class Method5:
    """
    48ms/77.68%/13.7MB/100.00%
    #5 Event事件对象法
    """
    def __init__(self):
        self.event1 = threading.Event()
        self.event2 = threading.Event()

    def first(self, printFirst: 'Callable[[], None]') -> None:
        printFirst()
        self.event1.set()

    def second(self, printSecond: 'Callable[[], None]') -> None:
        self.event1.wait()
        printSecond()
        self.event2.set()

    def third(self, printThird: 'Callable[[], None]') -> None:
        self.event2.wait()
        printThird()


class Method6:
    """
    48ms/77.68%/13.8MB/100.00%
    #6 Barrier栅栏对象法
    Barrier初始化的时候定义了parties = 2个等待线程，调用完了parties个wait就会释放线程
    """
    def __init__(self):
        self.barrier1 = threading.Barrier(2)
        self.barrier2 = threading.Barrier(2)

    def first(self, printFirst: 'Callable[[], None]') -> None:
        printFirst()
        self.barrier1.wait()

    def second(self, printSecond: 'Callable[[], None]') -> None:
        self.barrier1.wait()
        printSecond()
        self.barrier2.wait()

    def third(self, printThird: 'Callable[[], None]') -> None:
        self.barrier2.wait()
        printThird()


class Method7:
    """
    52ms/62.22%/14.1MB/100.00%
    #7 Queue队列法1
    直接使用多线程专用的阻塞队列，对于队列为空时，get方法就会自动阻塞，直到put使之非空才会释放进程。
    """
    def __init__(self):
        self.queue1 = queue.Queue()
        self.queue2 = queue.Queue()

    def first(self, printFirst: 'Callable[[], None]') -> None:
        printFirst()
        self.queue1.put(0)

    def second(self, printSecond: 'Callable[[], None]') -> None:
        self.queue1.get()
        printSecond()
        self.queue2.put(0)

    def third(self, printThird: 'Callable[[], None]') -> None:
        self.queue2.get()
        printThird()


class Method8:
    """
    68ms/23.07%/14MB/100.00%
    #8 Queue队列法2
    反过来，对于定容队列来说，如果队列满了，put方法也是阻塞。
    """
    def __init__(self):
        self.queue1 = queue.Queue(1)
        self.queue1.put(0)
        self.queue2 = queue.Queue(1)
        self.queue2.put(0)

    def first(self, printFirst: 'Callable[[], None]') -> None:
        printFirst()
        self.queue1.get()

    def second(self, printSecond: 'Callable[[], None]') -> None:
        self.queue1.put(0)
        printSecond()
        self.queue2.get()

    def third(self, printThird: 'Callable[[], None]') -> None:
        self.queue2.put(0)
        printThird()
