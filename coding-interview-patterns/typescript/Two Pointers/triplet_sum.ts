function tripletSum(nums: number[]): number[][] {
    const triplets: Array<[number, number, number]> = [];
    nums.sort();
    for (let i = 0; i < nums.length; i++) {
        // Optimization: triplets consisting of only positive numbers 
        // will never sum to 0.
        if (nums[i] > 0 ) 
            break;
        // To avoid duplicate triplets, skip 'a' if it's the same as 
        // the previous number.
        if (i > 0 && nums[i] === nums[i - 1]) 
            continue;
        // Find all pairs that sum to a target of '-a' (-nums[i]).
        const pairs = pairSumSortedAllPairs(nums, i + 1, -nums[i]);
        for (const pair of pairs) {
            triplets.push([nums[i], pair[0], pair[1]]);
        }
    }
    return triplets;
}

function pairSumSortedAllPairs(nums: number[], start: number, target: number): number[][] {
    const pairs: Array<[number, number]> = [];
    let left = start, right = nums.length - 1;
    while (left < right) {
        const sum = nums[left] + nums[right];
        if (sum === target) {
            pairs.push([nums[left], nums[right]]);
            left++;
            // To avoid duplicate '[b, c]' pairs, skip 'b' if it's the 
            // same as the previous number.
            while (left < right && nums[left] === nums[left - 1]) 
                left++;
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return pairs;
}
