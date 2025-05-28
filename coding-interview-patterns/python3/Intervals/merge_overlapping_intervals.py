from ds import Interval
from typing import List

"""
Definition of Interval:
class Interval:
    def __init__(self, start: int, end: int):
        self.start = start
        self.end = end
"""


def merge_overlapping_intervals(intervals: List[Interval]) -> List[Interval]:
    intervals.sort(key=lambda x: x.start)
    merged = [intervals[0]]
    for B in intervals[1:]:
        A = merged[-1]
        # If A and B don't overlap, add B to the merged list.
        if A.end < B.start:
            merged.append(B)
        # If they do overlap, merge A with B.
        else:
            merged[-1] = Interval(A.start, max(A.end, B.end))
    return merged
