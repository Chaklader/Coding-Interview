#include <vector>
#include <algorithm>
#include "ds/Interval.h"
using ds::Interval;

/**
 * Definition of Interval:
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval(int start, int end) : start(start), end(end) {}
 * };
 */

std::vector<Interval> mergeOverlappingIntervals(std::vector<Interval>& intervals) {
    std::sort(intervals.begin(), intervals.end(), [](Interval& a, Interval& b) {
        return a.start < b.start;
    });
    std::vector<Interval> merged;
    merged.push_back(intervals[0]);
    for (int i = 1; i < intervals.size(); i++) {
        Interval& A = merged.back();
        Interval& B = intervals[i];
        // If A and B don't overlap, add B to the merged list.
        if (A.end < B.start) {
            merged.push_back(B);
        }
        // If they do overlap, merge A with B.
        else {
            A.end = std::max(A.end, B.end);
        }
    }
    return merged;
}