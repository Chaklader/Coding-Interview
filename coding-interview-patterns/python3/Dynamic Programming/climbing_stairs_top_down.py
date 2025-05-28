memo = {}

def climbing_stairs_top_down(n: int) -> int:
    # Base cases: With a 1-step staircase, there's only one way to 
    # climb it. With a 2-step staircase, there are two ways to climb it.
    if n <= 2:
        return n
    if n in memo:
        return memo[n]
    # The number of ways to climb to the n-th step is equal to the sum 
    # of the number  of ways to climb to step n - 1 and to n - 2.
    memo[n] = (climbing_stairs_top_down(n - 1) + climbing_stairs_top_down(n - 2))
    return memo[n]
