#include <vector>
#include <map>
#include <utility>
#include <algorithm>
#include <numeric> 

int maximumCollinearPoints(std::vector<std::vector<int>>& points) {
    int res = 0;
    // Treat each point as a focal point, and determine the maximum
    // number of points that are collinear with each focal point. The
    // largest of these maximums is the answer.
    for (int i = 0; i < points.size(); i++) {
        res = std::max(res, maxPointsFromFocalPoint(i, points));
    }
    return res;
}

int maxPointsFromFocalPoint(int focalPointIndex, std::vector<std::vector<int>>& points) {
    std::map<std::pair<int, int>, int> slopesMap;
    int maxPoints = 0;
    // For the current focal point, calculate the slope between it and
    // every other point. This allows us to group points that share the
    // same slope.
    for (int j = 0; j < points.size(); j++) {
        if (j != focalPointIndex) {
            std::pair<int, int> currSlope = getSlope(points[focalPointIndex], points[j]);
            slopesMap[currSlope]++;
            // Update the maximum count of collinear points for the
            // current focal point.
            maxPoints = std::max(maxPoints, slopesMap[currSlope]);
        }
    }
    // Add 1 to the maximum count to include the focal point itself.
    return maxPoints + 1;
}

std::pair<int, int> getSlope(std::vector<int>& p1, std::vector<int>& p2) {
    int rise = p2[1] - p1[1];
    int run = p2[0] - p1[0];
    // Handle vertical lines separately to avoid dividing by 0.
    if (run == 0) {
        return {1, 0};
    }
    // Simplify the slope to its reduced form.
    int gcdVal = std::gcd(rise, run);
    return {rise / gcdVal, run / gcdVal};
}