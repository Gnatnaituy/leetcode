def climbStairs(self, n: int) -> int:
    cache = {}

    def recur(n: int) -> int:
        if n in cache:
            return cache[n]
        if n < 3:
            res = n
        else:
            res = cache[n - 1] + cache[n - 2]
        cache[n] = res

        return res
    
    return recur(n)
