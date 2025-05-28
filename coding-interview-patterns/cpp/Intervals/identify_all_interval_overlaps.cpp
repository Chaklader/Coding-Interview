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

std::vector<Interval> identifyAllIntervalOverlaps(std::vector<Interval>& intervals1, std::vector<Interval>& intervals2) {
    std::vector<Interval> overlaps;
    int i = 0;
    int j = 0;
    while (i < intervals1.size() && j < intervals2.size()) {
        // Set A to the interval that starts first and B to the other 
        // interval.
        Interval A, B;
        if (intervals1[i].start <= intervals2[j].start) {
            A = intervals1[i];
            B = intervals2[j];
        } else {
            A = intervals2[j];
            B = intervals1[i];
        }
        // If there's an overlap, add the overlap. Use `emplace_back`
        // to construct `Interval` in place, potentially avoiding an
        // extra copy compared to `push_back`. 
        if (A.end >= B.start) {
            overlaps.emplace_back(B.start, std::min(A.end, B.end));
        }
        // Advance the pointer associated with the interval that ends 
        // first.
        if (intervals1[i].end < intervals2[j].end) {
            i++;
        } else {
            j++;
        }
    }
    return overlaps;
}