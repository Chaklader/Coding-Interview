import 

fun maximumCollinearPoints(points: List<List<Int>>): Int {
    var res = 0
    // Treat each point as a focal point, and determine the maximum
    // number of points that are collinear with each focal point. The
    // largest of these maximums is the answer.
    for (i in points.indices) {
        res = maxOf(res, maxPointsFromFocalPoint(i, points))
    }
    return res
}

fun maxPointsFromFocalPoint(focalPointIndex: Int, points: List<List<Int>>): Int {
    val slopesMap = mutableMapOf<Pair<Int, Int>, Int>()
    var maxPoints = 0
    // For the current focal point, calculate the slope between it and
    // every other point. This allows us to group points that share the
    // same slope.
    for (j in points.indices) {
        if (j != focalPointIndex) {
            val currSlope = getSlope(points[focalPointIndex], points[j])
            slopesMap[currSlope] = slopesMap.getOrDefault(currSlope, 0) + 1
            // Update the maximum count of collinear points for the
            // current focal point.
            maxPoints = maxOf(maxPoints, slopesMap[currSlope]!!)
        }
    }
    // Add 1 to the maximum count to include the focal point itself.
    return maxPoints + 1
}

fun getSlope(p1: List<Int>, p2: List<Int>): Pair<Int, Int> {
    val rise = p2[1] - p1[1]
    val run = p2[0] - p1[0]
    // Handle vertical lines separately to avoid dividing by 0.
    if (run == 0) {
        return Pair(1, 0)
    }
    // Simplify the slope to its reduced form.
    val gcdVal = gcd(rise, run)
    return Pair(rise / gcdVal, run / gcdVal)
}

// Kotlin doesn't have a built-in GCD function, so we define one here.
fun gcd(a: Int, b: Int): Int {
    var num1 = a
    var num2 = b
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    return num1
}