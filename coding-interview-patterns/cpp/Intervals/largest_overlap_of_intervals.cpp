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

int largestOverlapOfIntervals(std::vector<Interval>& intervals) {
    std::vector<std::pair<int, char>> points;
    for (Interval& interval : intervals) {
        points.emplace_back(interval.start, 'S'); 
        points.emplace_back(interval.end, 'E');   
    }
    // Sort in chronological order. If multiple points occur at the same time,
    // ensure end points are prioritized before start points.
    std::sort(points.begin(), points.end());
    int activeIntervals = 0;
    int maxOverlaps = 0;
    for (auto& p : points) {
        int time = p.first;
        char pointType = p.second;
        if (pointType == 'S') {
            activeIntervals += 1;
        } else {
            activeIntervals -= 1;
        }
        maxOverlaps = std::max(maxOverlaps, activeIntervals);
    }
    return maxOverlaps;
}