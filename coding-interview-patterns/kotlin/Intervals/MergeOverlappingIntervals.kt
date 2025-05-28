import ds.Interval

/*
    Definition of Interval:
    data class Interval(var start: Int, var end: Int)
*/

fun mergeOverlappingIntervals(intervals: List<Interval>): List<Interval> {
    val sortedIntervals = intervals.sortedBy { it.start }
    val merged = mutableListOf(sortedIntervals[0])
    for (B in sortedIntervals.subList(1, sortedIntervals.size)) {
        val A = merged.last()
        // If A and B don't overlap, add B to the merged list.
        if (A.end < B.start) {
            merged.add(B)
            // If they do overlap, merge A with B.
        } else {
            merged[merged.size - 1] = Interval(A.start, maxOf(A.end, B.end))
        }
    }
    return merged
}
