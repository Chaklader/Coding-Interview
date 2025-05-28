def triangle_numbers(n: int) -> int:
    # If n is an odd-numbered row, the first even number always starts at position 
    # 2.
    if n % 2 != 0:
        return 2
    # If n is a multiple of 4, the first even number always starts at position 3.
    elif n % 4 == 0:
        return 3
    # For all other rows, the first even number always starts at position 4.
    return 4