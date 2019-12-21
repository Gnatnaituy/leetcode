def fibonacci(slef, N: int) -> int:
    """
    20ms 100%
    """

    cache = {}

    def recursive_fibonacci(N: int) -> int:
        if N in cache:
            return cache[N]
        if N < 2:
            result = N
        else:
            result = recursive_fibonacci(N - 1) + recursive_fibonacci(N - 2)
        cache[N] = result

        return result
    
    return recursive_fibonacci(N)