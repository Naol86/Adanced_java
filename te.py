from functools import lru_cache

@lru_cache(maxsize=1000)
def fibo(n):
    if n == 0 or n == 1:
        return 1
    return  fibo(n-1) + fibo(n - 2)

print(fibo(50))