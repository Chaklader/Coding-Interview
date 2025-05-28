from ds import Interval
from typing import List

"""
Definition of Interval:
class Interval:
    def __init__(self, start: int, end: int):
        self.start = start
        self.end = end
"""


def identify_all_interval_overlaps(intervals1: List[Interval], intervals2: List[Interval]) -> List[Interval]:
    overlaps = []
    i = j = 0
    while i < len(intervals1) and j < len(intervals2):
        # Set A to the interval that starts first and B to the other 
        # interval.
        if intervals1[i].start <= intervals2[j].start:
            A, B = intervals1[i], intervals2[j]
        else:
            A, B = intervals2[j], intervals1[i]
        # If there's an overlap, add the overlap.
        if A.end >= B.start:
            overlaps.append(Interval(B.start, min(A.end, B.end)))
        # Advance the pointer associated with the interval that ends 
        # first.
        if intervals1[i].end < intervals2[j].end:
            i += 1
        else:
            j += 1
    return overlaps
