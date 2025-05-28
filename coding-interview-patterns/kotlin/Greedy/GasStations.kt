fun gasStations(gas: List<Int>, cost: List<Int>): Int {
    // If the total gas is less than the total cost, completing the
    // circuit is impossible.
    if (gas.sum() < cost.sum()) {
        return -1
    }
    var start = 0
    var tank = 0
    for (i in 0 until gas.size) {
        tank += gas[i] - cost[i]
        // If our tank has negative gas, we cannot continue through the
        // circuit from the current start point, nor from any station
        // before or including the current station 'i'.
        if (tank < 0) {
            // Set the next station as the new start point and reset the
            // tank.
            start = i + 1
            tank = 0
        }
    }
    return start
}
