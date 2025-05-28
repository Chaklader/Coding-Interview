import ds.Interval

/*
    Definition of Interval:
    data class Interval(var start: Int, var end: Int)
*/

fun largestOverlapOfIntervals(intervals: List<Interval>): Int {
    val points = mutableListOf<Pair<Int, Char>>()
    for (interval in intervals) {
        points.add(interval.start to 'S')
        points.add(interval.end to 'E')
    }
    // Sort in chronological order. If multiple points occur at the same
    // time, ensure end points are prioritized before start points.
    points.sortWith(compareBy({ it.first }, { it.second }))
    var activeIntervals = 0
    var maxOverlaps = 0
    for ((time, pointType) in points) {
        if (pointType == 'S') {
            activeIntervals++
        } else {
            activeIntervals--
        }
        maxOverlaps = maxOf(maxOverlaps, activeIntervals)
    }
    return maxOverlaps
}