import ds.Interval

/*
    Definition of Interval:
    data class Interval(var start: Int, var end: Int)
*/

fun identifyAllIntervalOverlaps(intervals1: List<Interval>, intervals2: List<Interval>): List<Interval> {
    val overlaps = mutableListOf<Interval>()
    var i = 0
    var j = 0
    while (i < intervals1.size && j < intervals2.size) {
        // Set A to the interval that starts first and B to the other
        // interval.
        val (A, B) = if (intervals1[i].start <= intervals2[j].start) {
            intervals1[i] to intervals2[j]
        } else {
            intervals2[j] to intervals1[i]
        }
        // If there's an overlap, add the overlap.
        if (A.end >= B.start) {
            overlaps.add(Interval(B.start, minOf(A.end, B.end)))
        }
        // Advance the pointer associated with the interval that ends
        // first.
        if (intervals1[i].end < intervals2[j].end) {
            i++
        } else {
            j++
        }
    }
    return overlaps
}