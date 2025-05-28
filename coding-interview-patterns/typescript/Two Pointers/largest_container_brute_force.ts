function largestContainerBruteForce(heights: number[]): number {
    let n = heights.length;
    let maxWater = 0;
    // Find the maximum amount of water stored between all pairs of
    // lines.
    for (let i = 0; i < n - 1; i++) {
        for (let j = i + 1; j < n; j++) {
            let water = Math.min(heights[i], heights[j]) * (j - i);
            maxWater = Math.max(maxWater, water);
        }
    }
    return maxWater;
}
