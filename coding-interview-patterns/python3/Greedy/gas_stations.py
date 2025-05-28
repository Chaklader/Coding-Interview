from typing import List


def gas_stations(gas: List[int], cost: List[int]) -> int:
    # If the total gas is less than the total cost, completing the
    # circuit is impossible.
    if sum(gas) < sum(cost):
        return -1
    start = tank = 0
    for i in range(len(gas)):
        tank += gas[i] - cost[i]
        # If our tank has negative gas, we cannot continue through the 
        # circuit from the current start point, nor from any station 
        # before or including the current station 'i'.
        if tank < 0:
            # Set the next station as the new start point and reset the 
            # tank.
            start, tank = i + 1, 0
    return start
