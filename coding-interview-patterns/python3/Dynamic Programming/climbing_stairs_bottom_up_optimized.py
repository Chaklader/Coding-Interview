def climbing_stairs_bottom_up_optimized(n: int) -> int:
    if n <= 2:
        return n
    # Set 'one_step_before' and 'two_steps_before' as the base cases.
    one_step_before, two_steps_before = 2, 1
    for i in range(3, n + 1):
        # Calculate the number of ways to reach the current step.
        current = one_step_before + two_steps_before
        # Update the values for the next iteration.
        two_steps_before = one_step_before
        one_step_before = current
    return one_step_before
