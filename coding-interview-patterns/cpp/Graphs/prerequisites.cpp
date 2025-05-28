#include <vector>
#include <deque>

bool prerequisites(int n, std::vector<std::vector<int>>& prerequisites) {
    std::vector<std::vector<int>> graph(n);
    std::vector<int> inDegrees(n, 0);
    // Represent the graph as an adjacency list and record the in-degree 
    // of each course.
    for (auto& p : prerequisites) {
        int prerequisite = p[0];
        int course = p[1];
        graph[prerequisite].push_back(course);
        inDegrees[course]++;
    }
    std::deque<int> queue;
    // Add all courses with an in-degree of 0 to the queue.
    for (int i = 0; i < n; i++) {
        if (inDegrees[i] == 0) {
            queue.push_back(i);
        }
    }
    int enrolledCourses = 0;
    // Perform topological sort.
    while (!queue.empty()) {
        int node = queue.front();
        queue.pop_front();
        enrolledCourses++;
        for (int neighbor : graph[node]) {
            inDegrees[neighbor]--;
            // If the in-degree of a neighboring course becomes 0, add 
            // it to the queue.
            if (inDegrees[neighbor] == 0) {
                queue.push_back(neighbor);
            }
        }
    }
    // Return true if we've successfully enrolled in all courses.
    return enrolledCourses == n;
}