from ds import Interval
from typing import List

"""
Definition of Interval:
class Interval:
    def __init__(self, start: int, end: int):
        self.start = start
        self.end = end
"""


def largest_overlap_of_intervals(intervals: List[Interval]) -> int:
    points = []
    for interval in intervals:
        points.append((interval.start, 'S'))
        points.append((interval.end, 'E'))
    # Sort in chronological order. If multiple points occur at the same 
    # time, ensure end points are prioritized before start points.
    points.sort(key=lambda x: (x[0], x[1]))
    active_intervals = 0
    max_overlaps = 0
    for time, point_type in points:
        if point_type == 'S':
            active_intervals += 1
        else:
            active_intervals -= 1
        max_overlaps = max(max_overlaps, active_intervals)
    return max_overlaps
