fun prerequisites(n: Int, prerequisites: List<List<Int>>): Boolean {
    val graph = mutableMapOf<Int, MutableList<Int>>()
    val inDegrees = IntArray(n)
    // Represent the graph as an adjacency list and record the in-
    // degree of each course.
    for ((prerequisite, course) in prerequisites) {
        graph.getOrPut(prerequisite) { mutableListOf() }.add(course)
        inDegrees[course]++
    }
    val queue = ArrayDeque<Int>()
    // Add all courses with an in-degree of 0 to the queue.
    for (i in inDegrees.indices) {
        if (inDegrees[i] == 0) {
            queue.add(i)
        }
    }
    var enrolledCourses = 0
    // Perform topological sort.
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        enrolledCourses++
        for (neighbor in graph[node] ?: mutableListOf()) {
            inDegrees[neighbor]--
            // If the in-degree of a neighboring course becomes 0, add
            // it to the queue.
            if (inDegrees[neighbor] == 0) {
                queue.add(neighbor)
            }
        }
    }
    // Return true if we've successfully enrolled in all courses.
    return enrolledCourses == n
}
