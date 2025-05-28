function shiftZerosToTheEndNaive(nums: number[]): void {
    let temp: number[] = Array(nums.length).fill(0);
    let i = 0;
    // Add all non-zero elements to the left of 'temp'.
    for (let number of nums) {
        if (number !== 0) {
            temp[i] = number;
            i++;
        }
    }
    // Set 'nums' to 'temp'.
    for (let j = 0; j < nums.length; j++) {
        nums[j] = temp[j];
    }
}
